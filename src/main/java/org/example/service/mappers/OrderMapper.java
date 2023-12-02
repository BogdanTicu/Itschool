package org.example.service.mappers;

import org.example.model.dtos.orderDTOS.ResponseOrderDTO;
import org.example.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;
    public OrderMapper(CustomerMapper customerMapper, ProductMapper productMapper) {
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
    }

    public ResponseOrderDTO mapOrderToResponseOrderDTO(Order order) {
        return new ResponseOrderDTO(
                order.getId(),
                customerMapper.toDTO(order.getCustomer()),
                productMapper.toResponseDTO(order.getProduct()),
                order.getProduct_quantity()
        );
    }
}
