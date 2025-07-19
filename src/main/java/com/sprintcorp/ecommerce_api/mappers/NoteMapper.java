package com.sprintcorp.ecommerce_api.mappers;

import com.sprintcorp.ecommerce_api.dtos.NoteResponseDTO;
import com.sprintcorp.ecommerce_api.entities.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteResponseDTO noteDTO(Note note);
}
