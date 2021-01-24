package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsernameIsExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        AccountService service = new AccountService();

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.println("<response>");
        if (username.isBlank())
        {
            out.println("<msg>Empty</msg>");
            System.out.println("Empty");
        }
        else if(service.usernameIsExist(username)){
            out.println("<msg>Exist</msg>");
            System.out.println("Exist");
        }
        else {
            out.println("<msg>NotExist</msg>");
            System.out.println("NotExist");
        }
        out.println("</response>");
        out.flush();
        out.close();
    }
}
