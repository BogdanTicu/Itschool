package org.example.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Order {
    private int id;
    private int customerId;
    private int productId;
    private int totalPrice;
}
