package lk.ijse.dep12;

import jakarta.servlet.http.HttpFilter;

public class MyFilter1 extends HttpFilter {

    static {
        System.out.println("===========================================");
        System.out.println("MyFilter1 class object is being initialized");
    }
}
