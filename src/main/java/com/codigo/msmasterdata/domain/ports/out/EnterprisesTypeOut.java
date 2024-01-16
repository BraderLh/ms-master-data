package com.codigo.msmasterdata.domain.ports.out;

import com.codigo.msmasterdata.domain.model.EnterprisesType;

import java.util.List;
import java.util.Optional;

public interface EnterprisesTypeOut {
    EnterprisesType createEnterprisesType(EnterprisesType enterprisesType);
    Optional<EnterprisesType> findOneEnterprisesType( Long id);
    List<EnterprisesType> findAlllEnterprisesTypes();
    EnterprisesType updateEnterprisesType(Long id,EnterprisesType enterprisesType);
    Optional<EnterprisesType> deleteEnterprisesType(Long id); //UPDATE STATUS
}
