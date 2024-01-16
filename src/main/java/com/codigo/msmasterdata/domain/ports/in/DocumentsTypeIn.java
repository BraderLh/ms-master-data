package com.codigo.msmasterdata.domain.ports.in;

import com.codigo.msmasterdata.domain.model.DocumentsType;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DocumentsTypeIn {

    DocumentsType create(DocumentsType documentsType);
    Optional<DocumentsType> findOne(Long id);
    List<DocumentsType> findAlll();
    Optional<DocumentsType> update(Long id,DocumentsType documentsType);
    Optional<DocumentsType> delete(Long id); //UPDATE STATUS

}
