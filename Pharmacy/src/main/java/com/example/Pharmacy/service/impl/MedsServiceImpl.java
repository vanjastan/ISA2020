package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.OrderFormDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.MedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedsServiceImpl implements MedsService {

    @Autowired
    MedsRepository medsRepository;

    public List<Meds> findAll() throws AccessDeniedException {
        List<Meds> result = medsRepository.findAll();
        return result;
    }

    public Meds findByName(String name) throws UsernameNotFoundException {
        Meds m = medsRepository.findByName(name);
        return m;
    }

    public Meds addMeds(MedsDTO mdto) {
        Meds med = new Meds();

        med.setName(mdto.getName());
        med.setCode(mdto.getCode());
        med.setType(mdto.getType());
        med.setContradictions(mdto.getContradictions());
        med.setIngredients(mdto.getIngredients());
        med.setDailydose(mdto.getDailydose());
        med.setReplacement(mdto.getReplacement());
        med.setShape(mdto.getShape());
        med.setManufacturer(mdto.getManufacturer());
        med.setIssuing(mdto.getIssuing());
        med.setNotes(mdto.getNotes());

        med = this.medsRepository.save(med);

        return med;
    }

    public Meds addMed(OrderFormDTO dto){
        Meds m = new Meds();
        OrderForm of = new OrderForm();
        OrderFormDTO odto = new OrderFormDTO();

        if(of.getMedicamentName() != dto.getMeds_name().getName()){
            m.setName(dto.getMeds_name().getName());
            m = this.medsRepository.save(m);
        }else{

        }
        return m;
    }

}
