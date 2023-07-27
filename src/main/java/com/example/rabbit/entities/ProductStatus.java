package com.example.rabbit.entities;

import lombok.ToString;

@ToString
public class ProductStatus {

    private Product product;
    private String msg;

    public ProductStatus(Product product, String msg) {
        this.product = product;
        this.msg = msg;
    }

    public ProductStatus() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
