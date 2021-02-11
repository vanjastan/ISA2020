package com.example.Pharmacy.dto;

public class OrderFormOffersDTO {

    private Long id;
    private int price;
    private boolean winner;
    private boolean chosen;

    public OrderFormOffersDTO(){

    }

    public OrderFormOffersDTO(Long id,boolean chosen, int price,boolean winner ){
        this.id = id;
        this.chosen = chosen;
        this.price = price;
        this.winner = winner;
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
}
