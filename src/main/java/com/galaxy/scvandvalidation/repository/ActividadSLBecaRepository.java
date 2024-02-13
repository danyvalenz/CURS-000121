package com.galaxy.scvandvalidation.repository;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadSLBecaRepository  extends JpaRepository<ActividadSLBecaEntity,Long> {

/*
    @Modifying
    @Query(nativeQuery=true,value="truncate table POC_ACTIVIDADES_SL_BECAS") // SQL Nativo
    void truncateTabla(); */

    @Modifying
    @Query(value = "truncate table POC_ACTIVIDADES_SL_BECAS",nativeQuery = true)
    void truncateTabla();
}
