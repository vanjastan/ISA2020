package com.example.Pharmacy.mappers;

import com.example.Pharmacy.dto.PricelistDTO;
import com.example.Pharmacy.model.Pricelist;

public class PricelistMapper {

    public static PricelistDTO toDTO(Pricelist pricelist){

        return new PricelistDTO(pricelist);
    }

    private PricelistMapper(){

    }
}
