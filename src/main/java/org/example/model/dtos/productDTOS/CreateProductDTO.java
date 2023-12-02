package org.example.model.dtos.productDTOS;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CreateProductDTO {

    private String brand;
    private String model;
    private double price;
    private Long year;
}
