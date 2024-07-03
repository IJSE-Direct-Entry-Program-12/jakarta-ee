package lk.ijse.dep12;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter(filterName = "my-filter2", urlPatterns = "/hello2")
public class MyFilter2 extends HttpFilter {

    static {
        System.out.println("===========================================");
        System.out.println("MyFilter2 class object is being initialized");
    }
}
