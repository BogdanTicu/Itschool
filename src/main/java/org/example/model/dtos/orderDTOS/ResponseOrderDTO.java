package org.example.model.dtos.orderDTOS;

import lombok.*;
import org.example.model.dtos.customerDTOS.ResponseCustomerDTO;
import org.example.model.dtos.productDTOS.ResponseProductDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseOrderDTO {
    private Long id;
    private ResponseCustomerDTO customer_id;
    private ResponseProductDTO product_id;
    private int product_quantity;
}
