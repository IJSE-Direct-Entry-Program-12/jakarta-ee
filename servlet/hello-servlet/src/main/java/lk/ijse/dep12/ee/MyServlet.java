package lk.ijse.dep12.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("+++++++++++++++ Get Request +++++++++++++++++++");
        System.out.println("===============================================");
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            String tbodyHtml = "";
            for (int i = 0; i < 10; i++) {
                tbodyHtml  += """
                        <tr>
                            <td>1</td>
                            <td>Kasun Sampath</td>
                            <td>Galle</td>
                        </tr>
                        """;
            }
            out.println("""
                    <!DOCTYPE html>
                    <html lang="en">
                        <head>
                            <title>My First Servlet</title>
                        </head>
                        <body>
                            <h1>Hello Servlet</h1>
                            <h1>Server Date and Time: %s</h1>
                        </body>
                    </html>
                    """.formatted(LocalDateTime.now()));
        }
    }
}
