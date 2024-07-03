package lk.ijse.dep12;

import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Listener2 implements ServletRequestListener {

    static {
        System.out.println("===========================================");
        System.out.println("Listener2 class object is being initialized");
    }
}
