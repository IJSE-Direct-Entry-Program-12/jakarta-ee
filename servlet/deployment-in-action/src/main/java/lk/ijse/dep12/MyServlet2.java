package lk.ijse.dep12;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "my-servlet2", urlPatterns = "/hello2", loadOnStartup = 5)
public class MyServlet2 extends HttpServlet {

    static {
        System.out.println("============================================");
        System.out.println("MyServlet2 class object is being initialized");
        System.out.println("MyServlet2: " + MyServlet2.class.getClassLoader());
        new Customer();
    }
}
