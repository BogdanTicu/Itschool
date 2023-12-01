package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.dtos.CustomResponseDTO;
import org.example.model.dtos.CustomerDTO;
import org.example.model.dtos.ProductDTO;
import org.example.model.dtos.customerDTOS.CreateCustomerDTO;
import org.example.model.dtos.customerDTOS.ResponseCustomerDTO;
import org.example.service.CustomerMapper;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }
    @GetMapping(path="/all")
    public ResponseEntity<CustomResponseDTO> getAllCustomers() {
        List<ResponseCustomerDTO> customers = customerService.findAll();
        CustomResponseDTO response = new CustomResponseDTO();
        response.setData(customers);
        response.setMessage("All customers");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ResponseCustomerDTO> addCustomer(@Valid @RequestBody CreateCustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResponseCustomerDTO customer = customerService.save(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
        @GetMapping("/{id}")
    public ResponseEntity<ResponseCustomerDTO> getCustomerById(@PathVariable("id") Long id) {
        ResponseCustomerDTO customer = customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        CustomerDTO updatedCustomer = customerService.update(id, customerDTO);
//        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
       CustomResponseDTO response = new CustomResponseDTO();
        response.setMessage(customerService.deleteCustomer(id));
        return new ResponseEntity<>(response.getMessage(), HttpStatus.OK);
    }

}
