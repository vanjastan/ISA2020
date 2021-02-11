package com.example.Pharmacy.mappers;

import com.example.Pharmacy.dto.OrderFormOffersDTO;
import com.example.Pharmacy.model.OrderFormOffers;

public class OrderOfferMapper {

    public static OrderFormOffersDTO toDTO(OrderFormOffers orderFormOffers){
        return new OrderFormOffersDTO(orderFormOffers);
    }
}
