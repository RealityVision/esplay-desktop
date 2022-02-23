/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author slimd
 */
public class Order {
    private int orderId;
    private Date orderDate;
    private User client;
    private Product product;
    private String etat;
    private float priceProduit;
    private String productName;
    
    public Order(int orderId, Date orderDate, User client, String etat) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.client = client;
        this.etat = etat;
    }

    
    
    public Order(int orderId, Date orderDate, User client, Product product, String etat, float priceProduit, String productName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.client = client;
        this.product = product;
        this.etat = etat;
        this.priceProduit = product.getPrix();
        this.productName = product.getDescription();
    }

    public Order(int orderId, Date orderDate, Product product, String etat) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.product = product;
        this.etat = etat;
    }

    public Order(int orderId, Date orderDate, String etat) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.etat = etat;
    }
    
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.priceProduit = product.getPrix();
        this.productName = product.getDescription();
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getPriceProduit() {
        return priceProduit;
    }

    public void setPriceProduit(float priceProduit) {
        this.priceProduit = priceProduit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", client=" + client + ", product=" + product + ", etat=" + etat + ", priceProduit=" + priceProduit + ", productName=" + productName + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        return true;
    }
    
    
}
