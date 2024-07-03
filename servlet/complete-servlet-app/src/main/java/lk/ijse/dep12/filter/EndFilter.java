package lk.ijse.dep12.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EndFilter extends HttpFilter {

    {
        System.out.println("EndFilter class object is being loaded");
    }

    public EndFilter() {
        System.out.println("EndFilter() singleton is being constructed");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("EndFilter: init()");
        System.out.println("============================");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("EndFilter: Incoming Request");
        chain.doFilter(req, res);
        System.out.println("EndFilter: Outgoing Request");
    }
}
