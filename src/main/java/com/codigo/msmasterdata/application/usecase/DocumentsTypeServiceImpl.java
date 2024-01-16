package com.codigo.msmasterdata.application.usecase;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import com.codigo.msmasterdata.domain.ports.in.DocumentsTypeIn;
import com.codigo.msmasterdata.domain.ports.out.DocumentsTypeOut;

import java.util.List;
import java.util.Optional;

public class DocumentsTypeServiceImpl implements DocumentsTypeIn {
    private final DocumentsTypeOut documentsTypeOut;

    public DocumentsTypeServiceImpl(DocumentsTypeOut documentsTypeOut) {
        this.documentsTypeOut = documentsTypeOut;
    }

    @Override
    public DocumentsType create(DocumentsType documentsType) {
        return documentsTypeOut.createDocumentsType(documentsType);
    }

    @Override
    public Optional<DocumentsType> findOne(Long id) {
        return documentsTypeOut.findOneDocumentsType(id);
    }

    @Override
    public List<DocumentsType> findAlll() {
        return documentsTypeOut.findAlllDocumentsTypes();
    }

    @Override
    public Optional<DocumentsType> update(Long id, DocumentsType documentsType) {
        return documentsTypeOut.updateDocumentsType(id,documentsType);
    }

    @Override
    public Optional<DocumentsType> delete(Long id) {
        return documentsTypeOut.deleteDocumentsType(id);
    }
}
