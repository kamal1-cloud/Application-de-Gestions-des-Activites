package ma.youcode.GestionsDesActivites.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "typeevents", schema = "public", catalog = "GestionDesActivites")
public class TypeeventsEntity {
    private long idtypeevent;
    private String nom;
    private Collection<EventsEntity> eventsByIdtypeevent;


    public TypeeventsEntity(String nom) {
        this.nom = nom;
    }

    public TypeeventsEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtypeevent")
    public long getIdtypeevent() {
        return idtypeevent;
    }

    public void setIdtypeevent(long idtypeevent) {
        this.idtypeevent = idtypeevent;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeeventsEntity that = (TypeeventsEntity) o;

        if (idtypeevent != that.idtypeevent) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idtypeevent ^ (idtypeevent >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeeventsByIdtypeevent")
    public Collection<EventsEntity> getEventsByIdtypeevent() {
        return eventsByIdtypeevent;
    }

    public void setEventsByIdtypeevent(Collection<EventsEntity> eventsByIdtypeevent) {
        this.eventsByIdtypeevent = eventsByIdtypeevent;
    }
}
