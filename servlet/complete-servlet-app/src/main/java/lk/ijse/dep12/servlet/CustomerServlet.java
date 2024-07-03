package lk.ijse.dep12.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "customer-servlet", urlPatterns = "/customers", loadOnStartup = 0)
public class CustomerServlet extends HttpServlet {

    static {
        System.out.println("CustomerServlet class object is being initialized");
    }

    public CustomerServlet() {
        System.out.println("CustomerServlet() singleton instance");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("CustomerServlet: init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Customer Servlet");
        resp.getWriter().println("<h1>Customers</h1>");
    }
}
