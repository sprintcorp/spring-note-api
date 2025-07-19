package com.sprintcorp.ecommerce_api.services;

import com.sprintcorp.ecommerce_api.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
}
