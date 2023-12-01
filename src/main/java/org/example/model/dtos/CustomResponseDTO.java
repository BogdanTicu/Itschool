package org.example.model.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomResponseDTO {
    private String message;
    private Object data;
}
