package com.sprintcorp.ecommerce_api.services;

import com.sprintcorp.ecommerce_api.dtos.NoteResponseDTO;
import com.sprintcorp.ecommerce_api.entities.Note;
import com.sprintcorp.ecommerce_api.entities.User;
import com.sprintcorp.ecommerce_api.mappers.NoteMapper;
import com.sprintcorp.ecommerce_api.repositories.NoteRepository;
import com.sprintcorp.ecommerce_api.repositories.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final AuthRepository authRepository;
    private final NoteMapper noteMapper;

    public Note createNote(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Note text must not be empty");
        }

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = authRepository.findByEmail(email).orElseThrow();

        Note note = new Note();
        note.setText(text);
        note.setUser(user);

        return noteRepository.save(note);
    }

    public List<NoteResponseDTO> getMyNotes() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = authRepository.findByEmail(email).orElseThrow();

        return noteRepository.findAll().stream()
                .filter(n -> n.getUser().getId().equals(user.getId()))
                .map(noteMapper::noteDTO)
                .collect(Collectors.toList());
    }

    public Optional<Note> updateNote(Integer id, String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Note text must not be empty");
        }

        return noteRepository.findById(id).map(note -> {
            note.setText(text);
            return noteRepository.save(note);
        });
    }

    public String deleteNote(Integer id) {
        noteRepository.deleteById(id);
        return "Note deleted successfully";
    }
}
