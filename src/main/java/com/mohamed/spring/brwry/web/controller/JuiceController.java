package com.mohamed.spring.brwry.web.controller;

import com.mohamed.spring.brwry.services.JuiceService;
import com.mohamed.spring.brwry.web.model.JuiceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/juice")
@RestController
public class JuiceController {

    private final JuiceService juiceService;

    // dependency injection
    public JuiceController(JuiceService juiceService) {
        this.juiceService = juiceService;
    }

    @GetMapping("/{juiceId}")
    // ResponseEntity gives us more control of what we return back
    public ResponseEntity<JuiceDTO> getJuice(@PathVariable("juiceId") UUID juiceId) {
        return new ResponseEntity<>(juiceService.getJuiceById(juiceId), HttpStatus.OK);


    }




}
