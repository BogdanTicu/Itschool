package org.example.service;

import org.example.model.dtos.orderDTOS.CreateOrderDTO;
import org.example.model.dtos.orderDTOS.ResponseOrderDTO;
import org.example.model.entity.Customer;
import org.example.model.entity.Order;
import org.example.model.entity.Product;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    public OrderService(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    public ResponseOrderDTO createOrder(CreateOrderDTO createOrderDTO) {
       Customer customer = customerRepository.findById(createOrderDTO.getCustomer_id()).orElseThrow(() -> new RuntimeException("Customer not found"));
       Product product = productRepository.findById(createOrderDTO.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));
        Order order = new Order(
                customer,
                product,
                createOrderDTO.getProduct_quantity()
        );
        Order createDBorder = orderRepository.save(order);

        List<Order> orders = customer.getOrders();
        orders.add(createDBorder);
        customer.setOrders(orders);

        Set<Product> products = customer.getProducts();
        products.add(product);
        customer.setProducts(products);

        customerRepository.save(customer);

        return orderMapper.mapOrderToResponseOrderDTO(createDBorder);

    }

}
