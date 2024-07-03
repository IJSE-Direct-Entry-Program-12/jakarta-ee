package lk.ijse.dep12;

import jakarta.servlet.http.HttpServlet;

public class MyServlet1 extends HttpServlet {

    static {
        System.out.println("============================================");
        System.out.println("MyServlet1 class object is being initialized");
        System.out.println("MyServlet1: " + MyServlet1.class.getClassLoader());
        new Customer();
    }
}
