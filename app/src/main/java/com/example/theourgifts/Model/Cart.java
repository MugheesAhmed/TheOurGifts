package com.example.theourgifts.Model;

public class Cart {

    private String pname,price,quantity,pid,discount;

    public Cart() {
    }

    public Cart(String pname, String price, String quantity, String pid, String discount) {
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.pid = pid;
        this.discount = discount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
