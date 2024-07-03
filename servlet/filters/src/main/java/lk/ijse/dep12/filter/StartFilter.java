package lk.ijse.dep12.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Field;

//@WebFilter(filterName = "start-filter", urlPatterns = "/*")
public class StartFilter extends HttpFilter {

    static {
        System.out.println("StartFilter class object is being initialized");
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    public StartFilter() {
        System.out.println("StartFilter() Constructor");
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            System.out.println("init(FilterConfig)");
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                getServletContext();
            } catch (Exception e) {
                System.out.println("Yet to graduate");
                Field configInstanceVariable = GenericFilter.class.getDeclaredField("filterConfig");
                configInstanceVariable.setAccessible(true);
                System.out.println("config: " + configInstanceVariable.get(this));
            }
            super.init(config);
            Field configInstanceVariable = GenericFilter.class.getDeclaredField("filterConfig");
            configInstanceVariable.setAccessible(true);
            System.out.println("config: " + configInstanceVariable.get(this));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init()");
        System.out.println("Servlet Context: " + getServletContext());
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("StartFilter: Incoming Request");
        chain.doFilter(req, res);
        System.out.println("StartFilter: Outgoing Request");
    }
}
