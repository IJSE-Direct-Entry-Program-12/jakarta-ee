package lk.ijse.dep12.routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "servlet1", urlPatterns = "/hello1", loadOnStartup = 0)
public class Servlet1 extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("1. Service(ServletRequest, ServletResponse)");
        super.service(req, res);
        res.getWriter().println("<h1>Third</h1>");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2. Service(HttpServletRequest, HttpServletResponse)");
        super.service(req, resp);
        resp.getWriter().println("<h1>Second</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3. doXXX(HttpServletRequest, HttpServletResponse)");
        resp.getWriter().println("<h1>First</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy()");
    }
}
