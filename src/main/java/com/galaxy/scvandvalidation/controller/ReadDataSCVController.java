package com.galaxy.scvandvalidation.controller;

import com.galaxy.scvandvalidation.DTO.ActividadControllerResponse;
import com.galaxy.scvandvalidation.DTO.CSVActividadHelperResponse;
import com.galaxy.scvandvalidation.DTO.DataResponse;
import com.galaxy.scvandvalidation.helper.CSVHelper;
import com.galaxy.scvandvalidation.service.impl.ActividadSLBecaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class ReadDataSCVController {
    @Autowired
    private final CSVHelper csvHelper;
    @Autowired
    private final ActividadSLBecaServiceImpl actividadSLBecaService;

    public ReadDataSCVController(CSVHelper csvHelper, ActividadSLBecaServiceImpl actividadSLBecaService) {
        this.csvHelper = csvHelper;
        this.actividadSLBecaService = actividadSLBecaService;
    }


    @GetMapping("/saludo")
    public String saludo(){
        return "Hola";
    }

    @PostMapping("/load")
    public ResponseEntity<?> readFile(@RequestParam("file")MultipartFile file){
        try {

            InputStream inputStream = file.getInputStream();
            CSVActividadHelperResponse csvActividadHelperResponse = csvHelper.csvToList(inputStream);
            actividadSLBecaService.trucateReadData(csvActividadHelperResponse.getRegistrosValidos());


            DataResponse data = DataResponse
                    .builder()
                    .registrosValidos(csvActividadHelperResponse.getRegistrosValidos())
                    .registrosObservados(csvActividadHelperResponse.getRegistrosObservados())
                    .build();
            ActividadControllerResponse response = ActividadControllerResponse.builder()
                    .http_code(csvActividadHelperResponse.getSwObservados()?HttpStatus.BAD_REQUEST.name():HttpStatus.OK.name())
                    .swObservados(csvActividadHelperResponse.getSwObservados())
                    .total_registros_validos(csvActividadHelperResponse.getRegistrosValidos().size())
                    .total_registros_observados(csvActividadHelperResponse.getRegistrosObservados().size())
                    .data(data).build();

            return ResponseEntity.status(csvActividadHelperResponse.getSwObservados()? HttpStatus.BAD_REQUEST:HttpStatus.OK).body(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
