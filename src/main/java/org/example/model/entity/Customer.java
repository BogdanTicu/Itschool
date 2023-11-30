package org.example.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;

}
