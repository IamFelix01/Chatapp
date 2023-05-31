package controler;

import java.io.*;

import Entity.UsersEntity;
import dao.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Successful";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        String fn = request.getParameter("firstname");
        String ln = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UsersEntity user = new UsersEntity();
        user.setUsername(username);
        user.setFirstName(fn);
        user.setLastName(ln);
        user.setPassword(password);
        user.setEmail(email);
        UserManager userManager = new UserManager();
        if(userManager.save(user)){
            pr.println("<h1>"+message+"</h1>");
        }


    }

    public void destroy() {
    }
}
