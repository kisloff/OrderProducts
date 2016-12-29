package ru.kkiselev.model.POJO;

/**
 * Created by kv on 26.12.16.
 */
public class Basket_item {
    private int basket_id;
    private int product_id;
    private int qty;

    public int getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
