package com.galaxy.scvandvalidation.service;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;

import java.util.List;

public interface ActividadSLBecaService {
    List<ActividadSLBecaEntity> findAll();

    void readData(List<ActividadSLBecaEntity> lst);

    void deleteReadData(List<ActividadSLBecaEntity> lst);

    void trucateReadData(List<ActividadSLBecaEntity> lst);
}
