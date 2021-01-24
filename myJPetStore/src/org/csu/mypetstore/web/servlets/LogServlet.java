package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LogServlet extends HttpServlet {

    private static final String MyLog = "/WEB-INF/jsp/log/ViewLog.jsp";

    private List<Log> browseLogList;
    private List<Log> addToItemToCartLogList;

    private LogService logService;
    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        logService = new LogService();
        browseLogList = logService.getBrowseLogListByUsername(account.getUsername());
        addToItemToCartLogList = logService.getAddLogListByUsername(account.getUsername());
        session.setAttribute("browseLogList",browseLogList);
        session.setAttribute("addToItemToCartLogList",addToItemToCartLogList);
        request.getRequestDispatcher(MyLog).forward(request,response);
    }
}
