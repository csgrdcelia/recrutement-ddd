package model.entretien;

import java.util.Objects;

public class RecruteurId {
    final String id;

    public RecruteurId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruteurId that = (RecruteurId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecruteurId{" +
                "id='" + id + '\'' +
                '}';
    }
}
