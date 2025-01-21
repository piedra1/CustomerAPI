package com.edureka.CustomerAPI.controller;

import com.edureka.CustomerAPI.dto.OrderRequest;
import com.edureka.CustomerAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/orders")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(customerService.placeOrder(orderRequest));
    }

}
