package org.csu.mypetstore.service;

import java.util.List;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.CartDAO;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.impl.CartDAOImpl;
import org.csu.mypetstore.persistence.impl.CategoryDAOImpl;
import org.csu.mypetstore.persistence.impl.ItemDAOImpl;
import org.csu.mypetstore.persistence.impl.ProductDAOImpl;


public class CatalogService {
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;
    private CartDAO cartDAO;
    public CatalogService()
    {
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
        cartDAO = new CartDAOImpl();
    }
    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }

    public Cart getCart(String username)
    {
        return cartDAO.getCart(username);
    }

    public void updateCart(Cart cart, Account account)
    {
        cartDAO.updateCart(cart,account);
    }

    public void addItemToCart(Account account,CartItem cartItem)
    {
        cartDAO.addItemToCart(account,cartItem);
    }

    public void removeCart(Account account)
    {
        cartDAO.removeCart(account);
    }

    public void removeItemFromCart(Account account,String itemId)
    {
        cartDAO.removeItemFromCart(account,itemId);
    }
}
