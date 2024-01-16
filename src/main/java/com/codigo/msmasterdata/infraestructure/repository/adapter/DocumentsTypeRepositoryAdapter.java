package com.codigo.msmasterdata.infraestructure.repository.adapter;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import com.codigo.msmasterdata.domain.ports.out.DocumentsTypeOut;
import com.codigo.msmasterdata.infraestructure.entity.DocumentsTypeEntity;
import com.codigo.msmasterdata.infraestructure.repository.DocumentsTypeRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component
public class DocumentsTypeRepositoryAdapter implements DocumentsTypeOut {

    private final DocumentsTypeRepository repository;

    public DocumentsTypeRepositoryAdapter(DocumentsTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentsType createDocumentsType(DocumentsType documentsType) {
        DocumentsTypeEntity typeEntity = DocumentsTypeEntity.fromDomainModel(documentsType);
        DocumentsTypeEntity type = getEntity(documentsType,typeEntity);
        return repository.save(type).toDomainModel();
    }

    private DocumentsTypeEntity getEntity(DocumentsType documentsType, DocumentsTypeEntity documentsTypeEntity) {
        documentsTypeEntity.setStatus(1);
        documentsTypeEntity.setUserCreate("PRODRIGUEZ");
        documentsTypeEntity.setDateCreate(getTimestamp());
        return documentsTypeEntity;
    }
    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }

    @Override
    public Optional<DocumentsType> findOneDocumentsType(Long id) {
        return repository.findById(id).map(DocumentsTypeEntity::toDomainModel);
    }

    @Override
    public List<DocumentsType> findAlllDocumentsTypes() {
        return repository.findAll().stream().map(DocumentsTypeEntity::toDomainModel).toList();
    }

    @Override
    public Optional<DocumentsType> updateDocumentsType(Long id, DocumentsType documentsType) {
        if(repository.existsById(id)){
            DocumentsTypeEntity typeEntity = DocumentsTypeEntity.fromDomainModel(documentsType);
            return Optional.of(repository.save(typeEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<DocumentsType> deleteDocumentsType(Long id) {
        if(repository.existsById(id)){
            Optional<DocumentsTypeEntity> documentsType = repository.findById(id);
            documentsType.get().setStatus(0);
            return  Optional.of(repository.save(documentsType.get()).toDomainModel());
        }
        return Optional.empty();
    }
}
