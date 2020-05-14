package model;

import java.time.LocalDateTime;
import java.util.Date;

public class ConsultantRecruteur {

    private final String competence;
    private final LocalDateTime disponibilite;

    public ConsultantRecruteur(String competence, LocalDateTime disponibilite){
        this.competence = competence;
        this.disponibilite = disponibilite;
    }

}