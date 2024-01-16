package com.codigo.msmasterdata.infraestructure.repository;

import com.codigo.msmasterdata.infraestructure.entity.DocumentsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsTypeRepository extends JpaRepository<DocumentsTypeEntity, Long> {
}
