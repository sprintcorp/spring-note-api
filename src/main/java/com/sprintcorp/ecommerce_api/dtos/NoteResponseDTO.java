package com.sprintcorp.ecommerce_api.dtos;

import java.time.LocalDateTime;

public record NoteResponseDTO(
   Integer id,
   String text,
   ProfileUpdateDTO user,
   LocalDateTime createdAt,
   LocalDateTime updatedAt
) {}