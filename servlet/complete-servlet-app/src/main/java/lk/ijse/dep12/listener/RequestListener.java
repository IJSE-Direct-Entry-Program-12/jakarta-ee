package lk.ijse.dep12.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class RequestListener implements ServletRequestListener {

    static {
        System.out.println("1. ServletRequestListener class object is being initialized");
    }

    public RequestListener() {
        System.out.println("2. Singleton ServletRequestListener()");
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request object has been just destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request object has been just initialized");
    }
}
