package controler;
import java.io.*;
import java.sql.Timestamp;
import java.util.Collection;

import Entity.MessageEntity;
import Entity.UsersEntity;
import dao.MessageManager;
import dao.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SendMessageServlet", value = "/Send-Message-Servlet")
public class SendMessageServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        String Message = request.getParameter("Message");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(Message);
        HttpSession session = request.getSession();

        UsersEntity user = (UsersEntity) session.getAttribute("auth-user");
        int iduser = user.getId();
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent(Message);
        messageEntity.setTimestamp(timestamp);
        messageEntity.setUserId(iduser);
        MessageManager messageManager = new MessageManager();
        messageManager.save(messageEntity);

        Collection<MessageEntity> messages = messageManager.getAll();
        session.setAttribute("allmessages",messages);
        response.sendRedirect("ChatInterface.jsp");




    }

    public void destroy() {
    }
}
