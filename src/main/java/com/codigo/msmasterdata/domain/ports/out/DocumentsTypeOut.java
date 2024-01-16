package com.codigo.msmasterdata.domain.ports.out;

import com.codigo.msmasterdata.domain.model.DocumentsType;

import java.util.List;
import java.util.Optional;

public interface DocumentsTypeOut {
    DocumentsType createDocumentsType(DocumentsType documentsType);
    Optional<DocumentsType> findOneDocumentsType(Long id);
    List<DocumentsType> findAlllDocumentsTypes();
    Optional<DocumentsType> updateDocumentsType(Long id,DocumentsType documentsType);
    Optional<DocumentsType> deleteDocumentsType(Long id); //UPDATE STATUS
}
