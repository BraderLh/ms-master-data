package com.codigo.msmasterdata.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DocumentsType {
    private Long idDocumentsType;
    private String codType;
    private String descType;
    private int status;
    private String userCreate;
    private Timestamp dateCreate;
    private String userModif;
    private Timestamp dateModif;

    public DocumentsType(Long idDocumentsType, String codType, String descType, int status, String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.idDocumentsType = idDocumentsType;
        this.codType = codType;
        this.descType = descType;
        this.status = status;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }

    public DocumentsType() {

    }
}
