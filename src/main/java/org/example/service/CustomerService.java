package org.example.service;

import org.example.model.dtos.CustomerDTO;
import org.example.model.dtos.customerDTOS.CreateCustomerDTO;
import org.example.model.dtos.customerDTOS.ResponseCustomerDTO;
import org.example.model.entity.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper clientMapper;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper clientMapper) {
        this.customerRepository = customerRepository;
        this.clientMapper = clientMapper;
    }


    public List<ResponseCustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    public ResponseCustomerDTO save(CreateCustomerDTO customerDTO) {
        Customer customer = clientMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return clientMapper.toDTO(savedCustomer);

    }


    public void delete(Long id) {
    }
}

