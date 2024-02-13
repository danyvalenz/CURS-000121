package com.galaxy.scvandvalidation.helper;

import com.galaxy.scvandvalidation.DTO.CSVActividadHelperResponse;
import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import com.galaxy.scvandvalidation.entity.ModalidadEntity;
import com.galaxy.scvandvalidation.repository.ModalidadRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static  com.galaxy.scvandvalidation.utils.UtilValidator.isContent;

@Component
public class CSVHelper {


    private List<ModalidadEntity> lstModalidadEntity;
    private final ModalidadRepository modalidadRepository;

    public CSVHelper(ModalidadRepository modalidadRepository) {
        this.modalidadRepository = modalidadRepository;
    }

    public CSVActividadHelperResponse csvToList(InputStream is) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is/* , "UTF-8" */)); // JDK 1.8 en
             // adelante

             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.newFormat(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<ActividadSLBecaEntity> lstValidos = new ArrayList<>();
            List<ActividadSLBecaEntity> lstObservados = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            // Long x=1L;

            CSVActividadHelperResponse csvActividadResponse = new CSVActividadHelperResponse();
            StringBuffer observacion= new StringBuffer();
            Boolean swObservado;


            for (CSVRecord csvRecord : csvRecords) {

                swObservado=false;
                observacion= new StringBuffer();
                // ID
                ActividadSLBecaEntity aSLB = new ActividadSLBecaEntity();

                aSLB.setId(/* x++ */Long.valueOf(csvRecord.get("ID")));

                // ANIO
                String anio = csvRecord.get("ANIO");

                //if (isNull(anio) || anio.trim().length()==0) {
                if(isContent(anio)) {
                    observacion.append("El año es requerido");
                    swObservado=true;
                } else {
                    aSLB.setAnio(anio);
                }

                // MES
                aSLB.setMes(csvRecord.get("MES"));

                // FECHA
                aSLB.setFecha(csvRecord.get("FECHA"));

                // MODALIDAD

                String modalidad =csvRecord.get("MODALIDAD");

                if(isContent(anio)) {
                    observacion.append(", la modalidad es requerida");
                    swObservado=true;
                } else {
                    if (validarModalidad(modalidad)) {
                        aSLB.setModalid(modalidad);
                    }else {
                        observacion.append("la modalidad " + modalidad+ " no se encuentra registrada en la base de datos");
                        swObservado=true;
                    }
                }


                // LUGAR/PLATAFORMA
                aSLB.setLugarPlataforma(csvRecord.get("LUGARPLATAFORMA"));

                // TEMA DE LA CAPACITACION
                aSLB.setTemaCapacitacion(csvRecord.get("TEMACAPACITACION"));

                // EXPOSITORES
                aSLB.setExpositores(csvRecord.get("EXPOSITORES"));

                // DETALLE DE LA CAPACITACION
                aSLB.setDetalleCapacitacion(csvRecord.get("DETALLECAPACITACION"));
                if (swObservado) {
                    csvActividadResponse.setSwObservados(true);
                    aSLB.setObservacion(observacion.toString());
                    lstObservados.add(aSLB);
                }else {
                    lstValidos.add(aSLB);
                }

            }
            // fileReader.close();

            csvActividadResponse.setRegistrosValidos(lstValidos);
            csvActividadResponse.setRegistrosObservados(lstObservados);

            return csvActividadResponse;

        } catch (IOException e) {
            throw new RuntimeException("Error al leer archivo CSV:" + e.getMessage());
        }
    }

    private boolean validarModalidad(String modalidad) {

        if (lstModalidadEntity==null || lstModalidadEntity.isEmpty()) {
            lstModalidadEntity= modalidadRepository.findAll();
        }
        return ( lstModalidadEntity.stream().filter(e -> e.getNombre().toUpperCase().equalsIgnoreCase(modalidad))
                .findFirst().orElse(null) != null? true:false);
    }


}
