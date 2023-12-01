package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String brand;
    @Column(name = "product_type")
    private double price;
    @Column(name = "product_number_of_tables")
    private Date age;
    @ManyToMany(mappedBy = "product")
    private Set<Order> orders;
}
