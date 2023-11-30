package org.example.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
@Entity
public class Product {
    private int id;
    private String brand;
    private double price;
    private Date age;

}
