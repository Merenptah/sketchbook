package com.hg.sketchbook.spock.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> json() {
        return ResponseEntity.ok(new Response(
                new Response.ResponseData("Max Mustermann", "München"))
        );
    }
}