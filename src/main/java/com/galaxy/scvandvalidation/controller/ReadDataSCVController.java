package com.galaxy.scvandvalidation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReadDataSCVController {

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola";
    }


}
