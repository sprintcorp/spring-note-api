package com.sprintcorp.ecommerce_api.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
}
