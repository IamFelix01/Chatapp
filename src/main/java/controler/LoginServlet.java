package controler;
import java.io.*;
import java.util.Collection;

import Entity.UsersEntity;
import dao.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Successful";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        UserManager um = new UserManager();
        HttpSession session = request.getSession();
        UserManager userManager = new UserManager();
        UsersEntity user = userManager.FindUserByUsername(username);
        System.out.println("Hello "+user.getFirstName());
        session.setAttribute("auth-user", user);
        //Get all Users
        Collection<UsersEntity> AllUsers = userManager.getAll();
        session.setAttribute("allusers",AllUsers);




        //Redirection
        if(um.checkUser(username)){
            response.sendRedirect("ChatInterface.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
//        if(!user.getUsername().equals("")){
//            pr.println("<h1>Not Found</h1>");
//        } else {
//            pr.println("<h1>Hello"+user.getUsername()+"</h1>");
//
//        }


    }

    public void destroy() {
    }
}
