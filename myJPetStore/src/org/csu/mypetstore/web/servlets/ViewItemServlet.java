package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewItemServlet extends HttpServlet {
    private String itemId;
    private Product product;

    //新代码部分
    LogService logService;
    private Account account;

    private static final String View_Item = "/WEB-INF/jsp/catalog/Item.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        itemId = request.getParameter("itemId");

        //新代码部分
        account = (Account) session.getAttribute("account");
        logService = new LogService();
        if(account != null) logService.insertBrowseLog(account,itemId);


        CatalogService service = new CatalogService();
        Item item = service.getItem(itemId);
        product = item.getProduct();
        session.setAttribute("item",item);
        session.setAttribute("product",product);
        request.getRequestDispatcher(View_Item).forward(request,response);
    }

}
