package ma.youcode.GestionsDesActivites.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "specialite", schema = "public", catalog = "GestionDesActivites")

public class SpecialiteEntity {
    private long idspecialite;
    private String nom;
    private String salle;
    private Collection<FormateurEntity> formateursByIdspecialite;

    public SpecialiteEntity() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idspecialite")
    public long getIdspecialite() {
        return idspecialite;
    }

    public void setIdspecialite(long idspecialite) {
        this.idspecialite = idspecialite;
    }

    public SpecialiteEntity( String nom, String salle) {
        this.nom = nom;
        this.salle = salle;
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
    @Column(name = "salle")
    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialiteEntity that = (SpecialiteEntity) o;

        if (idspecialite != that.idspecialite) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (salle != null ? !salle.equals(that.salle) : that.salle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idspecialite ^ (idspecialite >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (salle != null ? salle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "specialiteByIdspecialite")
    public Collection<FormateurEntity> getFormateursByIdspecialite() {
        return formateursByIdspecialite;
    }

    public void setFormateursByIdspecialite(Collection<FormateurEntity> formateursByIdspecialite) {
        this.formateursByIdspecialite = formateursByIdspecialite;
    }
}
