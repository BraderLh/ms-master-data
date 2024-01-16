package com.codigo.msmasterdata.application.service;

import com.codigo.msmasterdata.domain.model.EnterprisesType;
import com.codigo.msmasterdata.domain.ports.in.EnterprisesTypeIn;

import java.util.List;
import java.util.Optional;

public class EnterprisesTypeService implements EnterprisesTypeIn {
    private final EnterprisesTypeIn enterprisesTypeIn;

    public EnterprisesTypeService(EnterprisesTypeIn enterprisesTypeIn) {
        this.enterprisesTypeIn = enterprisesTypeIn;
    }

    @Override
    public EnterprisesType create(EnterprisesType enterprisesType) {
        return enterprisesTypeIn.create(enterprisesType);
    }

    @Override
    public Optional<EnterprisesType> findOne(Long id) {
        return enterprisesTypeIn.findOne(id);
    }

    @Override
    public List<EnterprisesType> findAlll() {
        return enterprisesTypeIn.findAlll();
    }

    @Override
    public EnterprisesType update(Long id, EnterprisesType enterprisesType) {
        return enterprisesTypeIn.update(id,enterprisesType);
    }

    @Override
    public Optional<EnterprisesType> delete(Long id) {
        return enterprisesTypeIn.delete(id);
    }
}
