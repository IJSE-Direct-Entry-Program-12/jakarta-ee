package lk.ijse.dep12.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "item-servlet", urlPatterns = "/items")
public class ItemServlet extends HttpServlet {

    static {
        System.out.println("ItemServlet class object is being initialized");
    }

    public ItemServlet() {
        System.out.println("ItemServlet() singleton instance");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ItemServlet: init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ItemServlet Servlet");
        resp.getWriter().println("<h1>Items</h1>");
    }
}
