package com.sprintcorp.ecommerce_api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/note")
@AllArgsConstructor
public final class NoteController {

    public String index() {
        return  "Hello world";
    }
}
