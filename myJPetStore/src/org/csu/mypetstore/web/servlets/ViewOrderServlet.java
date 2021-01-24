package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class ViewOrderServlet extends HttpServlet {

    private static final String ViewOrder = "/WEB-INF/jsp/order/ViewOrder.jsp";

    private Order order;
    private OrderService service;
    private String msg;
    private Account account;
    private OrderService orderService;
    private CatalogService catalogService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        msg = request.getParameter("msg");
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        catalogService = new CatalogService();
        catalogService.removeCart(account);
        session.setAttribute("cart",null);
        if(msg.equals("new"))
        {
            order = (Order) session.getAttribute("order");
            service = new OrderService();
            service.insertOrder(order);
        }
        if(msg.equals("view"))
        {
            orderService = new OrderService();
            String orderId = request.getParameter("orderId");
            order = orderService.getOrder(Integer.parseInt(orderId));
        }
        session.setAttribute("order",order);
        request.getRequestDispatcher(ViewOrder).forward(request,response);
    }
}
