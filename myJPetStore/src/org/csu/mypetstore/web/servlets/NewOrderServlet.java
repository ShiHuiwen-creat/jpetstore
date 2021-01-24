package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewOrderServlet extends HttpServlet {

    private static final String NewOrder = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    Order order;
    Account account;
    Cart cart;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");

        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        cart = (Cart) session.getAttribute("cart");
        order = new Order();
        order.initOrder(account,cart);
        session.setAttribute("cardList",cardList);
        session.setAttribute("order",order);
        request.getRequestDispatcher(NewOrder).forward(request,response);
    }
}
