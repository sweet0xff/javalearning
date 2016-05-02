package cn.mldn.shop.vo;

import java.io.Serializable;

public class Details implements Serializable {
    private Integer odid;
    private Orders orders;
    private Goods goods;
    private Double price;
    private Integer amount;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
