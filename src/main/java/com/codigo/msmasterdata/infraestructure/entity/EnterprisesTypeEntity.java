package com.codigo.msmasterdata.infraestructure.entity;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import com.codigo.msmasterdata.domain.model.EnterprisesType;
import com.codigo.msmasterdata.infraestructure.entity.common.Audit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "enterprises_type")
@Getter
@Setter
public class EnterprisesTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enterprises_type")
    private Long idEnterprisesType;
    @Column(name = "desc_type", nullable = false)
    private String descType;

    @Column(name = "cod_type", nullable = false)
    private String codType;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "user_create")
    private String userCreate;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "user_modif")
    private String userModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    public EnterprisesTypeEntity(Long idEnterprisesType, String descType, String codType, int status, String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.idEnterprisesType = idEnterprisesType;
        this.descType = descType;
        this.codType = codType;
        this.status = status;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }

    public static EnterprisesTypeEntity fromDomainModel(EnterprisesType enterprisesType){
        return new EnterprisesTypeEntity(enterprisesType.getIdEnterprisesType(),
                enterprisesType.getCodType(),enterprisesType.getDescType(),enterprisesType.getStatus(),
                enterprisesType.getUserCreate(),enterprisesType.getDateCreate(), enterprisesType.getUserModif(),enterprisesType.getDateModif());
    }

    public EnterprisesType toDomainModel(){
        return new EnterprisesType(idEnterprisesType,codType,descType,status,userCreate,dateCreate,userModif,dateModif);
    }
}
