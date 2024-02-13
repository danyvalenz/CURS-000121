package com.galaxy.scvandvalidation.DTO;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import lombok.Data;

import java.util.List;

@Data
public class CSVActividadHelperResponse {
    private List<ActividadSLBecaEntity> registrosValidos;

    private List<ActividadSLBecaEntity> registrosObservados;

    private Boolean swObservados=false;

}
