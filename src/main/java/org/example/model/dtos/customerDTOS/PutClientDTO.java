package org.example.model.dtos.customerDTOS;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PutClientDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;
}
