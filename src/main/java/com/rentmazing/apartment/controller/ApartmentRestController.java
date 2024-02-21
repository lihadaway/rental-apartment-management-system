package com.rentmazing.apartment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApartmentRestController {

    @GetMapping(value = "/hello")
    String hello() {
        return "It works!";
    }

}