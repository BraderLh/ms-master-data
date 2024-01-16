package com.codigo.msmasterdata.domain.ports.in;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import com.codigo.msmasterdata.domain.model.EnterprisesType;

import java.util.List;
import java.util.Optional;

public interface EnterprisesTypeIn {
    EnterprisesType create(EnterprisesType enterprisesType);
    Optional<EnterprisesType> findOne(Long id);
    List<EnterprisesType> findAlll();
    EnterprisesType update(Long id,EnterprisesType enterprisesType);
    Optional<EnterprisesType> delete(Long id); //UPDATE STATUS
}
