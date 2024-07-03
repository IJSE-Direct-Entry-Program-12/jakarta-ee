package lk.ijse.dep12;

import jakarta.servlet.ServletContextListener;

public class Listener1 implements ServletContextListener {

    static {
        System.out.println("===========================================");
        System.out.println("Listener1 class object is being initialized");
    }
}
