package com.sprintcorp.ecommerce_api.controllers;

import com.sprintcorp.ecommerce_api.dtos.NoteDTO;
import com.sprintcorp.ecommerce_api.dtos.NoteResponseDTO;
import com.sprintcorp.ecommerce_api.entities.Note;
import com.sprintcorp.ecommerce_api.mappers.NoteMapper;
import com.sprintcorp.ecommerce_api.services.NoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
@AllArgsConstructor
public final class NoteController {

    private final NoteService noteService;
    private final NoteMapper noteMapper;

    @PostMapping
    public NoteResponseDTO create(@RequestBody @Valid NoteDTO body) {
        Note note = noteService.createNote(body.getText());
        return noteMapper.noteDTO(note);
    }

    @GetMapping
    public List<NoteResponseDTO> all() {
        return noteService.getMyNotes();
    }

    @PatchMapping("/{id}")
    public NoteResponseDTO update(@PathVariable Integer id, @RequestBody @Valid NoteDTO body) {
        Note note = noteService.updateNote(id, body.getText()).orElseThrow();
        return noteMapper.noteDTO(note);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return noteService.deleteNote(id);
    }
}
