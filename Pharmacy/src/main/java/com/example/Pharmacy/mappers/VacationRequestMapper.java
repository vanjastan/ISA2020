package com.example.Pharmacy.mappers;

import com.example.Pharmacy.dto.VacationRequestDTO;
import com.example.Pharmacy.model.VacationRequest;

public class VacationRequestMapper {

    public static VacationRequestDTO toDTO (VacationRequest vacationRequest){
       return new VacationRequestDTO(vacationRequest);
    }

    private VacationRequestMapper(){

    }
}
