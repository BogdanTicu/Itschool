package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.dtos.CustomResponseDTO;
import org.example.model.dtos.orderDTOS.CreateOrderDTO;
import org.example.repository.CustomerRepository;
import org.example.repository.ProductRepository;
import org.example.service.mappers.OrderMapper;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponseDTO> createOrder(@Valid @RequestBody CreateOrderDTO orderDTO, BindingResult bindingResult) {
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            customResponseDTO.setData(null);
            customResponseDTO.setMessage(errorMessage);
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }

        customResponseDTO.setData(orderService.createOrder(orderDTO));
        customResponseDTO.setMessage("Order created successfully");

        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }
}
