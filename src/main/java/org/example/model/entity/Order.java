package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_quantity")
    private int product_quantity;
}
