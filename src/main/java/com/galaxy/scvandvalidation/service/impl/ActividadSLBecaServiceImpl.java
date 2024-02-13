package com.galaxy.scvandvalidation.service.impl;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import com.galaxy.scvandvalidation.repository.ActividadSLBecaRepository;
import com.galaxy.scvandvalidation.service.ActividadSLBecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadSLBecaServiceImpl implements ActividadSLBecaService {

    @Autowired
    private ActividadSLBecaRepository actividadSLBecaRepository;
    @Override
    public List<ActividadSLBecaEntity> findAll() {
        return actividadSLBecaRepository.findAll();
    }

    @Override
    public void readData(List<ActividadSLBecaEntity> lst) {

    }

    @Override
    public void deleteReadData(List<ActividadSLBecaEntity> lst) {

    }

    @Override
    public void trucateReadData(List<ActividadSLBecaEntity> lst) {

    }
}
