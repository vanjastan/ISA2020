package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.PricelistDTO;
import com.example.Pharmacy.mappers.PricelistMapper;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Pricelist;
import com.example.Pharmacy.repository.PricelistRepository;
import com.example.Pharmacy.service.PricelistService;
import com.example.Pharmacy.service.impl.PricelistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pricelist")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    PricelistServiceImpl pricelistServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<PricelistDTO>> getPricelist(){
       List<Pricelist> pricelists = pricelistService.findAll();

       List<PricelistDTO> pricelistDTO = new ArrayList<>();

       for(Pricelist p : pricelists){
           pricelistDTO.add(new PricelistDTO(p));
       }

       return new ResponseEntity<>(pricelistDTO, HttpStatus.OK);
    }

   /* @GetMapping(value = "/{pharmacy_id}")
    @CrossOrigin
    public ResponseEntity<Collection<Pricelist>> getPricelistForPharmacy(@PathVariable("id") Long id){
        Collection<Pricelist> pricelist = pricelistServiceImpl.getPricelist();
        Collection<Pricelist> pricelistPH = new ArrayList<>();
        for(Pricelist p : pricelist){
            if(p.getPharm().getId() == id){
                pricelistPH.add(p);
            }
        }
        return  new ResponseEntity<Collection<Pricelist>>(pricelistPH, HttpStatus.OK);
    }*/

  /* @GetMapping(value = "/{pharmacy_id}")
    public ResponseEntity<List<Pricelist>> getPLbyPH (@PathVariable Long pharmacyId){
        Pricelist pricelist = pricelistService.findOne(pharmacyId);
        Collection<Pricelist> pr = pricelistServiceImpl.getPricelist();

        List<Pricelist> ph = new ArrayList<>();

        for(Pricelist p : pr){
            if(p.getPharm().getId() == pharmacyId){
                ph.add(p);
            }
        }
        return new ResponseEntity<>(ph, HttpStatus.OK);
    }*/

   /* @RequestMapping(value = "/{pharmacy_id}", method = RequestMethod.GET)
    public List<Pricelist> findPricelistByPharmacy(@PathVariable("id") Long id){
        List<Pricelist> pricelists = pricelistService.findByPharmacyId(id);
        return pricelists;
    }*/

    @CrossOrigin
    @PostMapping(value = "editPricelist")
   // @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<PricelistDTO> editPricelist (@RequestBody PricelistDTO dto){
        Pricelist pricelistInfo = pricelistService.findById(dto.getId());

        if(pricelistInfo == null){
            return null;
        }

        pricelistInfo.setPrice(dto.getPrice());
        pricelistInfo.setFrom_date(dto.getFrom_date());
        pricelistInfo.setTo_date(dto.getTo_date());

        pricelistInfo = pricelistService.save(pricelistInfo);

        return new ResponseEntity<>(PricelistMapper.toDTO(pricelistInfo), HttpStatus.OK);
    }

}
