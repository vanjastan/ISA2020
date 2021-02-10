package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.OrderFormOffersDTO;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.model.OrderFormOffers;
import com.example.Pharmacy.repository.OrderFormOffersRepository;
import com.example.Pharmacy.service.OrderFormOffersService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.OrderFormOffersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ofers")
public class OrderFormOffersController {

    @Autowired
    private OrderFormOffersServiceImpl orderFormOffersService;

    @Autowired
    private OrderFormOffersRepository orderFormOffersRepository;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<OrderFormOffersDTO>> getOrderOffer(){
        List<OrderFormOffers> orderFormOffers = orderFormOffersService.findAll();

        List<OrderFormOffersDTO> of = new ArrayList<>();

        for(OrderFormOffers o : orderFormOffers){
            OrderFormOffersDTO ofo = new OrderFormOffersDTO();
            ofo.setId(o.getId());
            ofo.setPrice(o.getPrice());
            ofo.setChosen(o.isChosen());
            ofo.setWinner(o.isWinner());

            of.add(ofo);
        }
        return new ResponseEntity<>(of, HttpStatus.OK);
    }



  /* @PostMapping("/chosen")
    public ResponseEntity<OrderFormOffersDTO> choseOrderOffer(@RequestBody OrderFormOffersDTO dto) throws MessagingException {
        OrderFormOffers orderFormOffers = orderFormOffersService.findById(dto.getId());

        orderFormOffers.setChosen(true);
        orderFormOffers.setWinner(true);
        emailServiceImpl.sendForOrder(orderFormOffers);

        orderFormOffers = orderFormOffersService.save(orderFormOffers);

        return  new ResponseEntity<>()
    }*/

}
