package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.other.makeCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //禁用缓存，每次访问此页面，都重新生成
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);

        //生成验证码的实例对象
        makeCode ie = new makeCode();

        //调用里面的方法，返回的是生成的验证码中的字符串
        String code = ie.getEnsure(0,0,response.getOutputStream());
        System.out.println("the code is "+code);


        //获得session，并把字符串保存在session中，为后面的对比做基础
        HttpSession session = request.getSession();
        session.setAttribute("strEnsure", code);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
