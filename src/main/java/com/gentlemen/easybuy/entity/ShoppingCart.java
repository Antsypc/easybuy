package com.gentlemen.easybuy.entity;

import java.util.List;

/**
 * 购物车类
 * Created by wang_zhao on 2016/6/30.
 */
public class ShoppingCart {
    // 购物车中货物集合
    private List<Orders> cartOrder;
    // 购物车车主
    private User user;

    public List<Orders> getCartOrder() {
        return cartOrder;
    }

    public void setCartOrder(List<Orders> cartOrder) {
        this.cartOrder = cartOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
