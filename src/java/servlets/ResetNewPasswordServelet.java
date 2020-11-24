package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 815000
 */
public class ResetNewPasswordServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String password = request.getParameter("password");
        
        AccountService as = new AccountService();
        
        if (as.changePassword(uuid, password)) {
            response.sendRedirect("login");            
        } else {
            final String ERROR = "Error to change the password, please try again.";
            request.setAttribute("error", ERROR);            
        }
    }

}
