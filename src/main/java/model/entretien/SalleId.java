package model.entretien;

import java.util.Objects;

public class SalleId {
    final String id;

    public SalleId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalleId that = (SalleId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SalleId{" +
                "id='" + id + '\'' +
                '}';
    }
}
