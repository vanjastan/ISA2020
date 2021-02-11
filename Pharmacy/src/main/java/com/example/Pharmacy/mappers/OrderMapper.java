package com.example.Pharmacy.mappers;

import com.example.Pharmacy.dto.OrderFormDTO;
import com.example.Pharmacy.model.OrderForm;

public class OrderMapper {

    public static OrderFormDTO toDTO(OrderForm orderForm){

        return new OrderFormDTO(orderForm);
    }
}
