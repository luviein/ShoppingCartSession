package com.example.httpsession.model;

import java.io.Serializable;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//SESSION NEEDS SERIALIZER
public class Item implements Serializable {
    @NotNull(message="Item name cannot be empty or null")
    @Size(min = 3, message ="Item name mut not be less than 3 char")
    private String name;

    @Min(value = 1 , message="Min Qty is 1")
    @Digits(integer = 5, fraction = 2, message ="Quantity is 5 digit and 2 decimals")
    private Integer quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
