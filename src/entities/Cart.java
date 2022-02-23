/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author slimd
 */
public class Cart {
    private int idCart;
    private User client;

    public Cart() {
    }

    public Cart(int idCart, User client) {
        this.idCart = idCart;
        this.client = client;
    }

    public Cart(int idCart) {
        this.idCart = idCart;
    }

    public Cart(User client) {
        this.client = client;
    }
    

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Cart other = (Cart) obj;
        if (this.idCart != other.idCart) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" + "idCart=" + idCart + ", client=" + client + '}';
    }

    
}


