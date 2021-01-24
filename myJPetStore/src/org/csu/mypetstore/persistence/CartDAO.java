package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

public interface CartDAO {
    public Cart getCart(String username);

    public void updateCart(Cart cart, Account account);

    public void addItemToCart(Account account,CartItem cartItem);

    public void removeCart(Account account);

    public void removeItemFromCart(Account account,String itemId);
}
