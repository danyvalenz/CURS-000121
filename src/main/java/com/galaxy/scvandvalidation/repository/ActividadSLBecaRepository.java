package com.galaxy.scvandvalidation.repository;

import com.galaxy.scvandvalidation.entity.ActividadSLBecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadSLBecaRepository  extends JpaRepository<ActividadSLBecaEntity,Long> {
}
