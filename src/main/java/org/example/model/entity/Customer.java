package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_phone")
    private String phone;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_age")
    private int age;

}
