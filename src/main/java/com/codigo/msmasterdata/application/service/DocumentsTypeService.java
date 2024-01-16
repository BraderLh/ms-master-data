package com.codigo.msmasterdata.application.service;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import com.codigo.msmasterdata.domain.ports.in.DocumentsTypeIn;

import java.util.List;
import java.util.Optional;

public class DocumentsTypeService implements DocumentsTypeIn {
    private final DocumentsTypeIn documentsTypeIn;
    public DocumentsTypeService(DocumentsTypeIn documentsTypeIn) {
        this.documentsTypeIn = documentsTypeIn;
    }

    @Override
    public DocumentsType create(DocumentsType documentsType) {
        return documentsTypeIn.create(documentsType);
    }

    @Override
    public Optional<DocumentsType> findOne(Long id) {
        return documentsTypeIn.findOne(id);
    }

    @Override
    public List<DocumentsType> findAlll() {
        return documentsTypeIn.findAlll();
    }

    @Override
    public Optional<DocumentsType> update(Long id, DocumentsType documentsType) {
        return documentsTypeIn.update(id,documentsType);
    }

    @Override
    public Optional<DocumentsType> delete(Long id) {
        return documentsTypeIn.delete(id);
    }
}
