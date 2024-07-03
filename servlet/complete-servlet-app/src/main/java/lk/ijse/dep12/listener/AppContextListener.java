package lk.ijse.dep12.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class AppContextListener implements ServletContextListener {

    static {
        System.out.println("1. AppContextListener class object is being initialized");
    }

    public AppContextListener() {
        System.out.println("2. Singleton AppContextListener()");
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("============================================");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("3. Servlet context has been just initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet context has been just destroyed");
    }
}
