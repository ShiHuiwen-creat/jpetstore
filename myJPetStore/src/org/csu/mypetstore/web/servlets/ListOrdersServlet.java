package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOrdersServlet extends HttpServlet {

    private static final String ListOrders = "/WEB-INF/jsp/order/ListOrders.jsp";

    Account account;
    List<Order> orderList;
    OrderService service;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        service = new OrderService();
        orderList = service.getOrdersByUsername(account.getUsername());
        session.setAttribute("orderList",orderList);
        request.getRequestDispatcher(ListOrders).forward(request,response);
    }
}
