package infrastructure.exception;

import java.time.LocalDateTime;

public class SalleIndisponible extends Exception{
    public SalleIndisponible(LocalDateTime date) {
        super("Le salle est indisponible pour la période " + date.toString());
    }
}
