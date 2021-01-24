package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AutoComplementServlet extends HttpServlet {

    CatalogService catalogService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        catalogService = new CatalogService();
        List<Product> productList = catalogService.searchProductList(keyword);
        System.out.println("productList" + productList);
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.println("<products>");
        for (Product product:productList) {
            out.println("<product>");
            out.println("<name>"+product.getName()+"</name>");
            out.println("</product>");
            System.out.println(product.getName());
        }
        out.println("</products>");
        out.flush();
        out.close();
    }
}
