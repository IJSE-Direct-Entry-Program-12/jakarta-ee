package lk.ijse.dep12.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("""
                        <!doctype html>
                        <html lang="en">
                            <head>
                                <title>Hello Servlet</title>
                            </head>
                            <body>
                                <h1>Hello Servlet - Oyaanam Harima Wadayak</h1>
                            </body>
                        </html>
                        """);
        }
    }
}
