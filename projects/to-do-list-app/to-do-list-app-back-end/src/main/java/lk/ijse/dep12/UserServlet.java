package lk.ijse.dep12;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "user-servlet", urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {


}
