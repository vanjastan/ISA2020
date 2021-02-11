package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.model.OrderFormOffers;

public class OrderFormOffersDTO {

    private Long id;
    private int price;
    private boolean winner;
    private boolean chosen;
    private Long orderForm;

    private OrderForm order;

    public OrderFormOffersDTO(){

    }

    public OrderFormOffersDTO(Long id,boolean chosen, int price,boolean winner ){
        this.id = id;
        this.chosen = chosen;
        this.price = price;
        this.winner = winner;

    }

    public OrderFormOffersDTO(OrderFormOffers o) {
        id = o.getId();
        price = o.getPrice();
        winner = o.isWinner();
        chosen = o.isChosen();
        orderForm = o.getOrderForm().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(Long orderForm) {
        this.orderForm = orderForm;
    }

    public OrderForm getOrder() {
        return order;
    }

    public void setOrder(OrderForm order) {
        this.order = order;
    }
}
