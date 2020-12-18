package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Medicament;
import com.example.Pharmacy.repository.MedicamentRepository;
import com.example.Pharmacy.service.impl.MedicamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    private MedicamentServiceImpl medicament;

    @Autowired
    private MedicamentRepository medicamentRepository;

   /* private final HttpClientService client;

    public MedicamentController(HttpClientService client) {
        this.client = client;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getMed(){
        ResponseEntity<?> result;
        try{
            List<MedicamentDTO> dtoList = client.getMed();
                    result = dtoList == null ?
                    ResponseEntity.badRequest().body("Bad request!") : new ResponseEntity<>(dtoList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity.badRequest().body("Bad request!");
        }
        return result;
    }*/

    //@GetMapping("/all")
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Medicament> loadAllMedicaments() {return this.medicamentRepository.findAll();}
}
