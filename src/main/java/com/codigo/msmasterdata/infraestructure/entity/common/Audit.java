package com.codigo.msmasterdata.infraestructure.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class Audit {
    @Column(name = "user_create")
    private String userCreate;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "user_modif")
    private String userModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    public Audit(String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }

}
