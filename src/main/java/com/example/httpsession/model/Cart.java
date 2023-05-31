package com.example.httpsession.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//SESSION NEEDS SERIALIZER
public class Cart implements Serializable{
    private List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public void addItemToCart(Item i) {
        this.items.add(i);
    }
     
}
