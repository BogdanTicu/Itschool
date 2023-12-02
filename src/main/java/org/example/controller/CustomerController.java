package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.dtos.CustomResponseDTO;
import org.example.model.dtos.customerDTOS.CreateCustomerDTO;
import org.example.model.dtos.customerDTOS.ResponseCustomerDTO;
import org.example.service.mappers.CustomerMapper;
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
        CustomResponseDTO responseDTO = new CustomResponseDTO();
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            responseDTO.setData(null);
            responseDTO.setMessage(errorMessage);
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


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
       CustomResponseDTO response = new CustomResponseDTO();
        response.setMessage(customerService.deleteCustomer(id));
        return new ResponseEntity<>(response.getMessage(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseCustomerDTO> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CreateCustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResponseCustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    @GetMapping("/mailOrPhone")
    public ResponseEntity<CustomResponseDTO> getCustomerByMailOrPhone(@RequestParam(required = false) String mail, @RequestParam(required = false) String phone) {
        List<ResponseCustomerDTO> customers = customerService.findByMailOrPhone(mail, phone);
        CustomResponseDTO response = new CustomResponseDTO();
        response.setData(customers);
        //response.setMessage("Customers with mail " + mail + " or phone " + phone);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
