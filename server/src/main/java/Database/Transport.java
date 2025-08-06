package Database;

import jakarta.persistence.*;

import java.util.Comparator;
import java.util.Objects;

@Entity
@Table(name = "Transport")
@NamedNativeQueries({
        @NamedNativeQuery(name="findA",query = "Select * from transport c where id = :id",resultClass = Transport.class),
        @NamedNativeQuery(name="findALL",query = "Select * from transport c order by c.nrLinie asc , c.nrstatie asc ",resultClass = Transport.class)})

public class Transport  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nrLinie;
    private String statie;
    private int nrStatie;

    public Transport() {
    }

    public Transport(int id, String nrLinie, String statie, int nrStatie) {
        this.id = id;
        this.nrLinie = nrLinie;
        this.statie = statie;
        this.nrStatie = nrStatie;
    }
    public Transport( String nrLinie, String statie, int nrStatie) {
        this.nrLinie = nrLinie;
        this.statie = statie;
        this.nrStatie = nrStatie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrLinie() {
        return nrLinie;
    }

    public void setNrLinie(String nrLinie) {
        this.nrLinie = nrLinie;
    }

    public String getStatie() {
        return statie;
    }

    public void setStatie(String statie) {
        this.statie = statie;
    }

    public int getNrStatie() {
        return nrStatie;
    }

    public void setNrStatie(int nrStatie) {
        this.nrStatie = nrStatie;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", nrLinie='" + nrLinie + '\'' +
                ", statie='" + statie + '\'' +
                ", nrStatie=" + nrStatie +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id && nrStatie == transport.nrStatie && Objects.equals(nrLinie, transport.nrLinie) && Objects.equals(statie, transport.statie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nrLinie, statie, nrStatie);
    }



}
