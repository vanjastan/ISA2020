package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.OrderFormDTO;
import com.example.Pharmacy.mappers.OrderMapper;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.model.OrderFormOffers;
import com.example.Pharmacy.repository.OrderFormRepository;
import com.example.Pharmacy.service.OrderFormOffersService;
import com.example.Pharmacy.service.OrderFormService;
import com.example.Pharmacy.service.impl.MedsServiceImpl;
import com.example.Pharmacy.service.impl.OrderFormServiceImpl;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orderform")
public class OrderFormController {

    @Autowired
    private OrderFormServiceImpl orderFormService;

    @Autowired
    private OrderFormService service;

    @Autowired
    private MedsServiceImpl medsService;

    @Autowired
    private OrderFormOffersService ooservice;

    @Autowired
    private OrderFormRepository orderFormRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
   // @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public  ResponseEntity<List<OrderFormDTO>> getAllOrderForms() throws AccessDeniedException {

        List<OrderForm> orderForms = orderFormService.findAll();

        List<OrderFormDTO> of = new ArrayList<>();

        for(OrderForm o : orderForms){
            OrderFormDTO dto = new OrderFormDTO();
            dto.setId(o.getId());
            dto.setMedicament_name(o.getMedicamentName());
            dto.setEnd_date(o.getEnd_date());
            dto.setQuantity(o.getQuantity());
            dto.setStatus(o.getStatus());

            of.add(dto);
        }

        return new ResponseEntity<>(of, HttpStatus.OK);
    }

    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity addOrderForm(@RequestBody OrderFormDTO dto) {
        orderFormService.addOrderForm(dto);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping(value = "/editOrder")
   // @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<OrderFormDTO> editOrder(@RequestBody OrderFormDTO dto){
        OrderForm orderForm = service.findById(dto.getId());
        List<OrderFormOffers> of = ooservice.findAll();

        if(orderForm == null){
            return null;
        }

        for(OrderFormOffers o : of){

            if(o.getOrderForm().getId() == dto.getId()) {

                    return null;
            }
        }

        orderForm.setEnd_date(dto.getEnd_date());
        orderForm.setMedicamentName(dto.getMedicament_name());
        orderForm.setStatus("not processed");
        orderForm.setQuantity(dto.getQuantity());

        orderForm = service.save(orderForm);

        return new ResponseEntity<>(OrderMapper.toDTO(orderForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity delete (@PathVariable Long id){
        OrderForm orderForm = service.findById(id);
        List<OrderFormOffers> ofers = ooservice.findAll();

        for(OrderFormOffers o : ofers){
            if(o.getOrderForm().getId() != orderForm.getId()){
                service.delete(id);
            }
        }


        return ResponseEntity.ok().build();
    }





}
