package com.codigo.msmasterdata.infraestructure.entity;

import com.codigo.msmasterdata.domain.model.DocumentsType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "documents_type")
@Getter
@Setter
@NoArgsConstructor
public class DocumentsTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documents_type")
    private Long idDocumentsType;

    @Column(name = "cod_type", nullable = false)
    private String codType;

    @Column(name = "desc_type", nullable = false)
    private String descType;

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

    public DocumentsTypeEntity(Long idDocumentsType, String codType, String descType, int status, String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.idDocumentsType = idDocumentsType;
        this.codType = codType;
        this.descType = descType;
        this.status = status;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }
    public static DocumentsTypeEntity fromDomainModel(DocumentsType documentsType){
        return new DocumentsTypeEntity(documentsType.getIdDocumentsType(),
                documentsType.getCodType(),documentsType.getDescType(),documentsType.getStatus(),
                documentsType.getUserCreate(),documentsType.getDateCreate(), documentsType.getUserModif(),documentsType.getDateModif());
    }
    public DocumentsType toDomainModel(){
        return new DocumentsType(idDocumentsType,codType,descType,status,userCreate,dateCreate,userModif,dateModif);
    }
}
