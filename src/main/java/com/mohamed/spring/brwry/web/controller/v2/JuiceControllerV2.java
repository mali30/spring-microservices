package com.mohamed.spring.brwry.web.controller.v2;

import com.mohamed.spring.brwry.services.v2.JuiceServiceV2;
import com.mohamed.spring.brwry.web.model.JuiceDTO;
import com.mohamed.spring.brwry.web.model.v2.JuiceDTOV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated  //evaluated on class level
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/juice")
@RestController
public class JuiceControllerV2 {


    // lombok handles the injection now
    private final JuiceServiceV2 juiceService;


        // dependency injection
//        public JuiceControllerV2(JuiceServiceV2 juiceService) {
//            this.juiceService = juiceService;
//        }

        @GetMapping("/{juiceId}")
        // ResponseEntity gives us more control of what we return back
        public ResponseEntity<JuiceDTO> getJuiceV2(@PathVariable("juiceId") UUID juiceId) {
            return new ResponseEntity(juiceService.getJuiceById(juiceId), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity postJuiceV2(@Valid @RequestBody JuiceDTOV2 juiceDTO) {

            // logging
            log.debug("In post handling");

            val createdJuice = juiceService.saveJuice(juiceDTO);

            // return to client the location it was created
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "http://localhost:8081/api/v1/juice" + createdJuice.getUuid().toString());

            return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
        }

        @PutMapping("/{juiceId}")
        public ResponseEntity updateJuiceV2(@PathVariable("juiceId") UUID juiceId, @Valid @RequestBody JuiceDTOV2 juiceDTO) {
            juiceService.updateJuiceV2(juiceId, juiceDTO);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }

        @DeleteMapping("/{juiceId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteJuiceV2(@PathVariable("juiceId") UUID juiceId) {
            juiceService.deleteByIdV2(juiceId);
            log.debug("Deleting the following juice with id " + juiceId);
        }

        /**
         * Exception handling
         */
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<List> validationErrorHandler(ConstraintViolationException exception) {
            List<String> errors = new ArrayList<>(exception.getConstraintViolations().size());
            exception.getConstraintViolations().forEach(violation ->{
                errors.add(violation.getPropertyPath() + ":" + violation.getMessage());
            });

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

