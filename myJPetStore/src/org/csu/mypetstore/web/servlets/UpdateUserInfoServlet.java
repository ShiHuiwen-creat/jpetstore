package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateUserInfoServlet extends HttpServlet {

    private static final String EditAccount = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String SignOn = "/WEB-INF/jsp/account/SignonForm.jsp";

    private String msg;
    private String username;
    private String password;
    private String repeatPassword;
    private AccountService service;
    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        msg = request.getParameter("msg");
        service = new AccountService();
        if(msg.equals("New"))
        {
            username = request.getParameter("username");
            password = request.getParameter("password");
            account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            if(username.equals(password))
            {
                service.insertAccount(account);
                msg = "Register successfully";
                HttpSession session = request.getSession();
                session.setAttribute("msg",msg);
                request.getRequestDispatcher(SignOn).forward(request,response);
            }else {
                msg = " The passwords entered are different";
            }
        }
        else if(msg.equals("Edit"))
        {
            password = request.getParameter("password");
            repeatPassword = request.getParameter("repeatPassword");
            HttpSession session = request.getSession();
            if (password.equals(repeatPassword))
            {
                account = (Account) session.getAttribute("account");
                if (!password.isEmpty()) account.setPassword(request.getParameter("password"));
                account.setFirstName(request.getParameter("account.firstName"));
                account.setLastName(request.getParameter("account.lastName"));
                account.setEmail(request.getParameter("account.email"));
                account.setPhone(request.getParameter("account.phone"));
                account.setAddress1(request.getParameter("account.address1"));
                account.setAddress2(request.getParameter("account.address2"));
                account.setCity(request.getParameter("account.city"));
                account.setState(request.getParameter("account.state"));
                account.setZip(request.getParameter("account.zip"));
                account.setCountry(request.getParameter("account.country"));
                account.setLanguagePreference(request.getParameter("account.languagePreference"));
                account.setFavouriteCategoryId(request.getParameter("account.favouriteCategoryId"));
                account.setListOption(request.getParameter("account.listOption") != null);
                account.setBannerOption(request.getParameter("account.BannerOption") != null);
                service.updateAccount(account);
                session.setAttribute("EditMsg","Edit Successfully");
                session.setAttribute("account",account);
            }
            else
            {
                session.setAttribute("EditMsg","Entered different passwords");
            }
            request.getRequestDispatcher(EditAccount).forward(request,response);
        }
    }
}
