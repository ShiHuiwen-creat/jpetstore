package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String View_Cart = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String Error = "/WEB-INF/jsp/common/Message.jsp";
    private String workingItemId;
    private Cart cart;
    private Account account;
    private CatalogService catalogService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");

        HttpSession session = request.getSession();
        cart = (Cart)session.getAttribute("cart");
        account = (Account) session.getAttribute("account");
        Item item = cart.removeItemById(workingItemId);
        catalogService = new CatalogService();
        catalogService.removeItemFromCart(account,workingItemId);
        if(item == null){
            session.setAttribute("message","Attempted to remove null CartItem from Cart.");
            request.getRequestDispatcher(Error).forward(request,response);
        }else {
            request.getRequestDispatcher(View_Cart).forward(request,response);
        }
    }
}
