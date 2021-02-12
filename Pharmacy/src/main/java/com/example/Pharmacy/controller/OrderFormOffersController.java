package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.OrderFormOffersDTO;
import com.example.Pharmacy.mappers.OrderOfferMapper;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.model.OrderFormOffers;
import com.example.Pharmacy.repository.OrderFormOffersRepository;
import com.example.Pharmacy.service.OrderFormOffersService;
import com.example.Pharmacy.service.OrderFormService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.OrderFormOffersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.nio.file.AccessDeniedException;
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
    private OrderFormOffersService service;

    @Autowired
    private OrderFormService ooservice;

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

    @CrossOrigin
    @PostMapping(value = "/choosen/{offerId}")
    public ResponseEntity<OrderFormOffersDTO> chooseOffer(@RequestBody OrderFormOffersDTO dto, @PathVariable("offerId") Long offerId) throws AccessDeniedException, MessagingException {
        OrderFormOffers orderFormOffers = service.findById(offerId);

        List<OrderForm> of = ooservice.findAll();
        OrderForm off = orderFormOffers.getOrderForm();


            if(off.getId() == orderFormOffers.getOrderForm().getId()){
                orderFormOffers.setWinner(true);
                orderFormOffers.setChosen(true);


                orderFormOffers = service.save(orderFormOffers);
                emailServiceImpl.sendForOrder(orderFormOffers);
                //sending email that ordering is finished and winner is informed.
                emailServiceImpl.sendForOrders(orderFormOffers);

            }

        return new ResponseEntity<>(OrderOfferMapper.toDTO(orderFormOffers), HttpStatus.OK);
    }

}
