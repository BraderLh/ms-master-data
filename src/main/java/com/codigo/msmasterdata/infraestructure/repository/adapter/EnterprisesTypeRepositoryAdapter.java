package com.codigo.msmasterdata.infraestructure.repository.adapter;

import com.codigo.msmasterdata.domain.model.EnterprisesType;
import com.codigo.msmasterdata.domain.ports.out.EnterprisesTypeOut;
import com.codigo.msmasterdata.infraestructure.entity.EnterprisesTypeEntity;
import com.codigo.msmasterdata.infraestructure.repository.EnterprisesTypeRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component
public class EnterprisesTypeRepositoryAdapter implements EnterprisesTypeOut {
    private final EnterprisesTypeRepository enterprisesTypeRepository;

    public EnterprisesTypeRepositoryAdapter(EnterprisesTypeRepository enterprisesTypeRepository) {
        this.enterprisesTypeRepository = enterprisesTypeRepository;
    }

    private Timestamp getTimestamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
    @Override
    public EnterprisesType createEnterprisesType(EnterprisesType enterprisesType) {
        EnterprisesTypeEntity enterprisesTypeEntity = EnterprisesTypeEntity.fromDomainModel(enterprisesType);
        enterprisesTypeEntity.setStatus(1);
        enterprisesTypeEntity.setDateCreate(getTimestamp());
        enterprisesTypeEntity.setUserCreate("PRODRIGUEZ");
        return enterprisesTypeRepository.save(enterprisesTypeEntity).toDomainModel();
    }

    @Override
    public Optional<EnterprisesType> findOneEnterprisesType(Long id) {
        if (enterprisesTypeRepository.existsById(id)) {
            return enterprisesTypeRepository.findById(id).map(EnterprisesTypeEntity::toDomainModel);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<EnterprisesType> findAllEnterprisesTypes() {
        return enterprisesTypeRepository.findAll().stream().map(EnterprisesTypeEntity::toDomainModel).toList();
    }

    @Override
    public Optional<EnterprisesType> updateEnterprisesType(Long id, EnterprisesType enterprisesType) {
        if (enterprisesTypeRepository.existsById(id)) {
            EnterprisesTypeEntity enterpriseToUpdate = EnterprisesTypeEntity.fromDomainModel(enterprisesType);
            Optional<EnterprisesTypeEntity> actualEnterprise = enterprisesTypeRepository.findById(id);
            actualEnterprise.ifPresent(enterprise -> enterprise.setCodType(enterprisesType.getCodType() != null ? enterprisesType.getCodType() : actualEnterprise.get().getCodType()));
            actualEnterprise.ifPresent(enterprise -> enterprise.setDescType(enterprisesType.getDescType() != null ? enterprisesType.getDescType() : actualEnterprise.get().getDescType()));
            actualEnterprise.ifPresent(enterprise -> enterprise.setUserModif("BRAYAN LIPE"));
            actualEnterprise.ifPresent(enterprise -> enterprise.setDateModif(getTimestamp()));
            return Optional.of(enterprisesTypeRepository.save(actualEnterprise.get()).toDomainModel());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<EnterprisesType> deleteEnterprisesType(Long id) {
        if (enterprisesTypeRepository.existsById(id)) {
            Optional<EnterprisesTypeEntity> enterprisesTypeEntity = enterprisesTypeRepository.findById(id);
            enterprisesTypeEntity.ifPresent(typeEntity -> typeEntity.setStatus(0));
            return Optional.of(enterprisesTypeRepository.save(enterprisesTypeEntity.get()).toDomainModel());
        } else {
            return Optional.empty();
        }
    }
}
