package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShipServlet extends HttpServlet {

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("shipToFirstName",request.getParameter("order.shipToFirstName"));
        session.setAttribute("shipToLastName",request.getParameter("order.shipToLastName"));
        session.setAttribute("shipAddress1",request.getParameter("order.shipAddress1"));
        session.setAttribute("shipAddress2",request.getParameter("order.shipAddress2"));
        session.setAttribute("shipCity",request.getParameter("order.shipCity"));
        session.setAttribute("shipState",request.getParameter("order.shipState"));
        session.setAttribute("shipZip",request.getParameter("order.shipZip"));
        session.setAttribute("shipCountry",request.getParameter("order.shipCountry"));
        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
    }
}
