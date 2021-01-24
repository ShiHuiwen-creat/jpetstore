package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class ConfirmOrderServlet extends HttpServlet {

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";

    Order order;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("cardType",request.getParameter("cardType"));
        session.setAttribute("cardNumber",request.getParameter("order.creditCard"));
        order = (Order) session.getAttribute("order");
        Boolean toShip = (request.getParameter("shippingAddressRequired") != null);
        if(toShip)
        {
            order.setShipToFirstName(request.getParameter("order.shipToFirstName"));
            order.setShipToLastName(request.getParameter("order.shipToLastName"));
            order.setShipAddress1(request.getParameter("order.shipAddress1"));
            order.setShipAddress2(request.getParameter("order.shipAddress2"));
            order.setShipCity(request.getParameter("order.shipCity"));
            order.setShipState(request.getParameter("order.shipState"));
            order.setShipZip(request.getParameter("order.shipZip"));
            order.setShipCountry(request.getParameter("order.shipCountry"));
        }
        order.setOrderDate(new Date(System.currentTimeMillis()));
        session.setAttribute("order",order);
        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
    }
}
