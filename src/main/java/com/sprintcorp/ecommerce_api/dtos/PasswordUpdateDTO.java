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
public class PasswordUpdateDTO {
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "New Password should not be empty")
    private String newPassword;

    @NotEmpty(message = "Confirm Password should not be empty")
    private String confirmPassword;
}
