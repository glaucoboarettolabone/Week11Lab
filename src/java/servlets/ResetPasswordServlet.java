package servlets;

import java.io.IOException;
import javax.mail.Message;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 815000
 */
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("uuid");
        if (param == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);            
        } else {
            request.setAttribute("uuid", param);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF");
        String url = request.getRequestURL().toString();
        
        AccountService as = new AccountService();
        as.resetPassword(email, path, url);
        
        final String MESSAGE = "Reset link has been sent to your email.";
        request.setAttribute("message", MESSAGE);
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }

}
