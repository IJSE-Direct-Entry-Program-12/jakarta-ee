package lk.ijse.dep12;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "my-servlet", urlPatterns = "/hello1", loadOnStartup = 0)
public class MyServlet extends HttpServlet {

    static {
        System.out.println("1. MyServlet class object is being loaded");
    }

    public MyServlet() {
        System.out.println("2. MyServlet constructor()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("3. Entered: GenericServlet init()");
        try {
            getServletContext();
        }catch (Throwable t){
            System.out.println("4. Yet to graduate");
        }
        super.init(config);
        System.out.println("6. Exited: GenericServlet init()");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("5. Init()");
        System.out.println("5. Servlet Context: " + getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
    }
}
