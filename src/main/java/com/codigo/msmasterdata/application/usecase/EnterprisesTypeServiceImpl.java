package com.codigo.msmasterdata.application.usecase;

import com.codigo.msmasterdata.domain.model.EnterprisesType;
import com.codigo.msmasterdata.domain.ports.in.EnterprisesTypeIn;
import com.codigo.msmasterdata.domain.ports.out.EnterprisesTypeOut;

import java.util.List;
import java.util.Optional;

public class EnterprisesTypeServiceImpl implements EnterprisesTypeIn {
    private final EnterprisesTypeOut enterprisesTypeOut;

    public EnterprisesTypeServiceImpl(EnterprisesTypeOut enterprisesTypeOut) {
        this.enterprisesTypeOut = enterprisesTypeOut;
    }

    @Override
    public EnterprisesType create(EnterprisesType enterprisesType) {
        return enterprisesTypeOut.createEnterprisesType(enterprisesType);
    }

    @Override
    public Optional<EnterprisesType> findOne(Long id) {
        return enterprisesTypeOut.findOneEnterprisesType(id);
    }

    @Override
    public List<EnterprisesType> findAlll() {
        return enterprisesTypeOut.findAlllEnterprisesTypes();
    }

    @Override
    public EnterprisesType update(Long id, EnterprisesType enterprisesType) {
        return enterprisesTypeOut.updateEnterprisesType(id,enterprisesType);
    }

    @Override
    public Optional<EnterprisesType> delete(Long id) {
        return enterprisesTypeOut.deleteEnterprisesType(id);
    }
}
