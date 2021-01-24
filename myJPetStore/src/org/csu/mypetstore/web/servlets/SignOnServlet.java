package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {
    private static final String Main = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String ErrorString = "Wrong username or password";
    private static final String VerifyCodeError = "Wrong VerifyCode";
    private static final String SignOn = "/WEB-INF/jsp/account/SignonForm.jsp";
    private String username;
    private String password;
    private String vCode;
    private String stdCode;
    private Account account;

    private AccountService service;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        password = request.getParameter("password");
        service = new AccountService();
        account = service.getAccount(username,password);
        HttpSession session=request.getSession();
        vCode = request.getParameter("vcode");
        stdCode = request.getSession().getAttribute("strEnsure").toString();


        if (check(vCode, stdCode)){
            //account 不为空
            if(account != null ){
                System.out.println("验证码正确并且用户存在");
                session.setAttribute("account",account);
                session.setAttribute("username","");
                session.setAttribute("password","");
                request.getRequestDispatcher(Main).forward(request,response);
            }
            else {
                session.setAttribute("message",ErrorString);
                session.setAttribute("username",username);
                request.getRequestDispatcher(SignOn).forward(request,response);
            }
        }else
        {
            session.setAttribute("message",VerifyCodeError);
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            request.getRequestDispatcher(SignOn).forward(request,response);
        }
    }

    public boolean check(String a,String b){
        System.out.println(a+"  "+b);
        char[] as=a.toCharArray();
        char[] bs=b.toCharArray();
        for (int i = 0;i < 4;i++){
            System.out.println("第 " +i+" 个 "+((int)as[i]- (int)bs[i]) +" "+(Math.abs((int)as[i] - (int)bs[i]) != 32));
            if (!(Math.abs((int)as[i] - (int)bs[i]) == 32 || Math.abs((int)as[i] - (int)bs[i]) == 0))
                return false;
        }
        return true;
    }
}
