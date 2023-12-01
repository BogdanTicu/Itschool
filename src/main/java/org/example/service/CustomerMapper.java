package org.example.service;

import org.example.model.dtos.customerDTOS.CreateCustomerDTO;
import org.example.model.dtos.customerDTOS.ResponseCustomerDTO;
import org.example.model.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CreateCustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setAge(customerDTO.getAge());
        return customer;
    }

    public ResponseCustomerDTO toDTO(Customer savedCustomer) {
        ResponseCustomerDTO responseCustomerDTO = new ResponseCustomerDTO();
        responseCustomerDTO.setId(savedCustomer.getId());
        responseCustomerDTO.setName(savedCustomer.getName());
        responseCustomerDTO.setEmail(savedCustomer.getEmail());
        responseCustomerDTO.setPhone(savedCustomer.getPhone());
        responseCustomerDTO.setAddress(savedCustomer.getAddress());
        responseCustomerDTO.setAge(savedCustomer.getAge());
        return responseCustomerDTO;
    }
}
