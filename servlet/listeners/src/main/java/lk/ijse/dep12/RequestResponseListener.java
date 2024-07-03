package lk.ijse.dep12;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestResponseListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request ekak aaawa: " + sre.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request eka process karala iwarai");
    }
}
