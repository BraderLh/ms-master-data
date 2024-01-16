package com.codigo.msmasterdata.infraestructure.config;

import com.codigo.msmasterdata.application.service.DocumentsTypeService;
import com.codigo.msmasterdata.application.service.EnterprisesTypeService;
import com.codigo.msmasterdata.application.usecase.DocumentsTypeServiceImpl;
import com.codigo.msmasterdata.application.usecase.EnterprisesTypeServiceImpl;
import com.codigo.msmasterdata.domain.ports.out.DocumentsTypeOut;
import com.codigo.msmasterdata.domain.ports.out.EnterprisesTypeOut;
import com.codigo.msmasterdata.infraestructure.repository.EnterprisesTypeRepository;
import com.codigo.msmasterdata.infraestructure.repository.adapter.DocumentsTypeRepositoryAdapter;
import com.codigo.msmasterdata.infraestructure.repository.adapter.EnterprisesTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public DocumentsTypeService documentsTypeService(DocumentsTypeOut documentsTypeOut){
        return new DocumentsTypeService(new DocumentsTypeServiceImpl(documentsTypeOut));
    }

    @Bean
    public DocumentsTypeOut documentsTypeOut(DocumentsTypeRepositoryAdapter documentsTypeRepositoryAdapter){
        return documentsTypeRepositoryAdapter;
    }

    @Bean
    public EnterprisesTypeService enterprisesTypeService(EnterprisesTypeOut enterprisesTypeOut) {
        return new EnterprisesTypeService(new EnterprisesTypeServiceImpl(enterprisesTypeOut));
    }

    @Bean
    public EnterprisesTypeOut enterprisesTypeOut(EnterprisesTypeRepositoryAdapter enterprisesTypeRepositoryAdapter) {
        return enterprisesTypeRepositoryAdapter;
    }
}
