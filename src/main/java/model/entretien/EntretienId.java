package model.entretien;

import java.util.Objects;

public class EntretienId {
    final String id;

    public EntretienId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntretienId that = (EntretienId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EntretienId{" +
                "id='" + id + '\'' +
                '}';
    }
}
