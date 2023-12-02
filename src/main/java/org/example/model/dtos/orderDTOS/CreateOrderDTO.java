package org.example.model.dtos.orderDTOS;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateOrderDTO {
    private Long customer_id;
    private Long product_id;
    private int product_quantity;
}
