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
        public ResponseCustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDTO(customer);
    }

//    public ResponseCustomerDTO update(Long id, CreateCustomerDTO customerDTO) {
//        // trebuie verificat daca clientul exista in baza de date
//        // daca exista ii facem o mapare cu datele din patchClientDTO in clientul din baza de date si salvam clientul in baza de date cu datele actualizate si returnam clientul actualizat
//        // daca nu exista aruncam o exceptie
//        // trebuie verificat daca ce primim in patchClientDTO este este diferit de ce avem in baza de date
//
//    }


    public String deleteCustomer(Long id)
     {
        customerRepository.deleteById(id);
        return "Customer removed !! " + id;
     }
}

