package com.sprintcorp.ecommerce_api.repositories;

import com.sprintcorp.ecommerce_api.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Integer> {
}
