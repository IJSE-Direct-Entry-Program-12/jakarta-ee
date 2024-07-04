package lk.ijse.dep12;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "user-servlet", urlPatterns = "/users/*")
@MultipartConfig(location = "/tmp", maxFileSize = 5 * 1024 * 1024)
public class UserServlet extends HttpServlet {

    @Resource(lookup = "java:comp/env/jdbc/to-do-app-db")
    private DataSource pool;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Part picture = req.getPart("picture");

        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("""
                        INSERT INTO "user" (email, password, name, picture) VALUES (?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.setString(3, name);
            stm.setBinaryStream(4, picture.getInputStream());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int newUserId = rs.getInt("id");

            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_CREATED);

            resp.getWriter().println("""
                {
                    "id": %s,
                    "email": "%s",
                    "name": "%s"
                }
            """.formatted(newUserId, email, name));
            resp.getWriter().flush();
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
        if (req.getMethod().equalsIgnoreCase("PATCH")){
            doPatch(req, resp);
        }else{
            super.service(req, resp);
        }
    }


}
