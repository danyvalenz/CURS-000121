package com.galaxy.scvandvalidation.repository;

import com.galaxy.scvandvalidation.entity.ModalidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<ModalidadEntity,Long> {
}
