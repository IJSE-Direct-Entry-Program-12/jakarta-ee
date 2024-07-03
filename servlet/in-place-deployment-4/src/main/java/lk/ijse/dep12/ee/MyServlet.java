package lk.ijse.dep12.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = "/index.php")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("""
                    <!doctype html>
                    <html lang="en">
                        <head>
                            <title>Fourth In Place Deployment</title>
                        </head>
                        <body>
                            <h1>My Fourth In Place Deployment</h1>
                            <h1>My Fourth In Place Deployment</h1>
                            <h1>My Fourth In Place Deployment</h1>
                        </body>
                    </html>      
                    """);
        }
    }
}
