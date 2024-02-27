package com.nickrankin.ca1.CA1.Web.Services.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nickrankin.ca1.CA1.Web.Services.model.Form;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FormController {

    @GetMapping("/forms")
    public ResponseEntity<List<Form>> getForms() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Try to parse the Forms.json inside applications resource folder. Parse this file server side, so if there was any failure parsing the file monitoring tools will pick it up.
            List<Form> forms = mapper.readValue(new ClassPathResource("./Forms.json").getFile(), new TypeReference<List<Form>>() {});

            return new ResponseEntity(forms, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

            // Log the Stacktrace to System out, and send a generic error in response
            return new ResponseEntity("Fatal error while retrieving forms list. Support will be notified.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
