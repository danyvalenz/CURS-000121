package com.galaxy.scvandvalidation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ReadDataSCVController {

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola";
    }

    @PostMapping("/load")
    public ResponseEntity<?> readFile(@RequestParam("file")MultipartFile file){
        try {

            return null;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
