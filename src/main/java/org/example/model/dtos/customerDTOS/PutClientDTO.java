package org.example.model.dtos.customerDTOS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PutClientDTO {
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    private String phone;
    private String address;
    private int age;
}
