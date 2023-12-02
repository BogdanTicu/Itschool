package org.example.model.dtos.productDTOS;

import lombok.*;
import org.example.model.entity.Order;


import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ResponseProductDTO {
    private Long id;
    private String brand;
    private String model;
    private double price;
    private Long year;
    private Set<Order> orders;
}
