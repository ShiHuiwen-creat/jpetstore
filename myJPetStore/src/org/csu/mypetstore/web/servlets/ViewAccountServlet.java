package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewAccountServlet extends HttpServlet {
    private static final String EditAccount = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String NewAccount = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String SignOn = "/WEB-INF/jsp/account/SignonForm.jsp";
    private String typeOfMeg;
    Account account;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        typeOfMeg = request.getParameter("msg");
        if(typeOfMeg.equals("SignOn"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("message","Please enter your username and password.");
            request.getRequestDispatcher(SignOn).forward(request,response);
        }

        else if(typeOfMeg.equals("Edit"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("EditMsg",null);
            request.getRequestDispatcher(EditAccount).forward(request,response);
        }
        else if(typeOfMeg.equals("New"))
            request.getRequestDispatcher(NewAccount).forward(request,response);
    }
}
