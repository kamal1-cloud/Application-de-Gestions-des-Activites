package ma.youcode.GestionsDesActivites.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "events", schema = "public", catalog = "GestionDesActivites")
public class EventsEntity{
    private long idevent;
    private String nom;
    private String description;
    private Long organisateur;
    private Time starttime;
    private Time endtime;
    private Date startdate;
    private Date enddate;
    private Long idtypeevent;
    private UsersEntity usersByOrganisateur;
    private TypeeventsEntity typeeventsByIdtypeevent;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevent")
    public long getIdevent() {
        return idevent;
    }

    public void setIdevent(long idevent) {
        this.idevent = idevent;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "organisateur")
    public Long getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Long organisateur) {
        this.organisateur = organisateur;
    }

    @Basic
    @Column(name = "starttime")
    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime")
    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "idtypeevent")
    public Long getIdtypeevent() {
        return idtypeevent;
    }

    public void setIdtypeevent(Long idtypeevent) {
        this.idtypeevent = idtypeevent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (idevent != that.idevent) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (organisateur != null ? !organisateur.equals(that.organisateur) : that.organisateur != null) return false;
        if (starttime != null ? !starttime.equals(that.starttime) : that.starttime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;
        if (idtypeevent != null ? !idtypeevent.equals(that.idtypeevent) : that.idtypeevent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idevent ^ (idevent >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (organisateur != null ? organisateur.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (idtypeevent != null ? idtypeevent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "organisateur", referencedColumnName = "iduser" , insertable = false, updatable = false)
    public UsersEntity getUsersByOrganisateur() {
        return usersByOrganisateur;
    }

    public void setUsersByOrganisateur(UsersEntity usersByOrganisateur) {
        this.usersByOrganisateur = usersByOrganisateur;
    }

    @ManyToOne
    @JoinColumn(name = "idtypeevent", referencedColumnName = "idtypeevent" , insertable = false, updatable = false)
    public TypeeventsEntity getTypeeventsByIdtypeevent() {
        return typeeventsByIdtypeevent;
    }

    public void setTypeeventsByIdtypeevent(TypeeventsEntity typeeventsByIdtypeevent) {
        this.typeeventsByIdtypeevent = typeeventsByIdtypeevent;
    }
}
