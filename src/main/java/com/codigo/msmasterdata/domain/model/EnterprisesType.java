package com.codigo.msmasterdata.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class EnterprisesType {
    private Long idEnterprisesType;
    private String descType;
    private String codType;
    private int status;
    private String userCreate;
    private Timestamp dateCreate;
    private String userModif;
    private Timestamp dateModif;

    public EnterprisesType(Long idEnterprisesType, String descType, String codType, int status, String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.idEnterprisesType = idEnterprisesType;
        this.descType = descType;
        this.codType = codType;
        this.status = status;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }
}
