package com.codigo.msmasterdata.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Audit {
    private String userCreate;
    private Timestamp dateCreate;
    private String userModif;
    private Timestamp dateModif;

    public Audit(String userCreate, Timestamp dateCreate, String userModif, Timestamp dateModif) {
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.userModif = userModif;
        this.dateModif = dateModif;
    }

    public Audit() {
    }
}
