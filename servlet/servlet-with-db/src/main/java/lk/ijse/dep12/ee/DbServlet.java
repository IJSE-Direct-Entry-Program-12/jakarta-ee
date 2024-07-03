package lk.ijse.dep12.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DbServlet extends HttpServlet {

    public DbServlet() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:12500/dep12_java_ee_servlet",
                "postgres", "psql")) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM customer");
            String tableBodyHtml = "<tbody>";
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                String rowHtml = """
                        <tr>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                        </tr>
                        """.formatted(id, name, address);
                tableBodyHtml += rowHtml;
            }
            tableBodyHtml += "</tbody>";

            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {
                out.println("""
                        <!doctype html>
                        <html lang="en">
                            <head>
                                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                                <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>                            
                                <title>Customer Table</title>
                            </head>
                            <body class="container">
                                <h1>Customers</h1>
                                <table class="table table-hover table-border">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>NAME</th>
                                            <th>ADDRESS</th>
                                        </tr>
                                    </thead>
                                    %s
                                </table>
                            </body>
                        </html>""".formatted(tableBodyHtml));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
