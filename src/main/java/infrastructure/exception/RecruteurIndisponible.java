package infrastructure.exception;

import java.time.LocalDateTime;

public class RecruteurIndisponible extends Exception {
    public RecruteurIndisponible(LocalDateTime date) {
        super("Le recruteur est indisponible pour la période " + date.toString());
    }
}
