package com.example.httpsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.httpsession.model.Cart;
import com.example.httpsession.model.Item;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    
    @GetMapping
    public String showCart(Model m, HttpSession session) {
        //landing page instantiates new cart after invalidating
        Cart c = (Cart) session.getAttribute("cart");
        if(c == null) {
            c = new Cart();
            session.setAttribute("cart", c);
        }

        m.addAttribute("item", new Item());
        m.addAttribute("cart", c);
        return "cart";
    }

    @PostMapping
    public String postCart(Model m, HttpSession session, @Valid Item item, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            return"cart";
        }
        //session only stores objects, need to cast to cart
        Cart c = (Cart) session.getAttribute("cart");
        if(c == null) {
            c = new Cart();
            session.setAttribute("cart", c);
        }
        c.addItemToCart(item);
        m.addAttribute("item", item);
        m.addAttribute("cart", c);
        return "cart";
    }

    //m.addattribute is to reset items in the cart
    @GetMapping(path="/checkout")
    public String checkout(Model m, HttpSession session){
        //invalidates current session not model
        session.invalidate();
        m.addAttribute("item", new Item());
        m.addAttribute("cart", new Cart());
        return "cart";
    }
    
}
