package com.galaxy.scvandvalidation.DTO;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DataResponse {
    private List<ActividadSLBecaEntity> registrosValidos;

    private List<ActividadSLBecaEntity> registrosObservados;

}
