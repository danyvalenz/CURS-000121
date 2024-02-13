package com.galaxy.scvandvalidation.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"http_code","swObservados", "total_registros_validos","total_registros_observados"})
public class ActividadControllerResponse {

    private String 	http_code;
    private Integer total_registros_validos;
    private Integer total_registros_observados;
    private Boolean swObservados;

    private DataResponse data;
}
