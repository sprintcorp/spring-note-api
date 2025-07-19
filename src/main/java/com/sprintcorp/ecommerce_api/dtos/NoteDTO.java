package com.sprintcorp.ecommerce_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class NoteDTO {
    @NotBlank(message = "Note text must not be blank")
    private String text;
}