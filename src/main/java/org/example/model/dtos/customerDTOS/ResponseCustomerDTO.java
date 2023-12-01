package org.example.model.dtos.customerDTOS;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.example.model.entity.Order;
import org.example.model.entity.Product;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) //nu-ti arata campuri nule
public class ResponseCustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;
    private List<Order> orders;
    private Set<Product> products;


}
