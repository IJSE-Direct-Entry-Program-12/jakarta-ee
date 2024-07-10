package lk.ijse.dep12;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lk.ijse.dep12.to.ErrorResponse;
import lk.ijse.dep12.to.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Set;

@WebServlet(name = "user-servlet", urlPatterns = "/users/*")
@MultipartConfig(location = "/tmp", maxFileSize = 5 * 1024 * 1024)
public class UserServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();
    @Resource(lookup = "java:comp/env/jdbc/to-do-app-db")
    private DataSource pool;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Part picture = req.getPart("picture");

        User user = new User(null, name, email, password, picture);
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<User>> violationSet = validator.validate(user);
            if (!violationSet.isEmpty()) {
                resp.setContentType("application/json");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                mapper.writeValue(resp.getWriter(), new ErrorResponse(400, "Bad Request",
                        "Validation Failed", violationSet));
                return;
            }
        }

        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("""
                        INSERT INTO "user" (email, password, name, picture) VALUES (?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.setString(3, name);
            stm.setBinaryStream(4, picture == null ? null : picture.getInputStream());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int newUserId = rs.getInt("id");
            user.setId(newUserId);

            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_CREATED);

            mapper.writeValue(resp.getWriter(), user);

        } catch (SQLException e) {
            resp.getWriter().println("<h1>Failed to save the user: %s</h1>".formatted(e.getMessage()));
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>GET USER</h1>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>DELETE USER</h1>");
    }

    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>PATCH USER</h1>");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("PATCH")) {
            doPatch(req, resp);
        } else {
            super.service(req, resp);
        }
    }


}
