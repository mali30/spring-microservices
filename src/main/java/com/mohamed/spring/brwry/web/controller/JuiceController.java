package com.mohamed.spring.brwry.web.controller;

import com.mohamed.spring.brwry.services.JuiceService;
import com.mohamed.spring.brwry.web.model.JuiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
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

    @PostMapping
    public ResponseEntity postJuice(@RequestBody JuiceDTO juiceDTO){
        JuiceDTO createdJuice = juiceService.saveJuice(juiceDTO);

        // return to client the location it was created
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location" , "http://localhost:8081/api/v1/juice"+ createdJuice.getUuid().toString());

        return new ResponseEntity(httpHeaders , HttpStatus.CREATED);
    }

    @PutMapping("/{juiceId}")
    public ResponseEntity updateJuice(@PathVariable("juiceId") UUID juiceId,  @RequestBody JuiceDTO juiceDTO){
        juiceService.updateJuice(juiceId , juiceDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{juiceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJuice(@PathVariable("juiceId") UUID juiceId) {
        juiceService.deleteById(juiceId);
        log.debug("Deleting the following juice with id " + juiceId );
    }




}
