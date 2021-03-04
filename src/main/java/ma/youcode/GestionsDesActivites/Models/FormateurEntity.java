package ma.youcode.GestionsDesActivites.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "formateur", schema = "public")
@PrimaryKeyJoinColumn(name = "idUser")
public class FormateurEntity extends UsersEntity{

    private long idformateur;
    private Long iduser;
    private Long idspecialite;
    private Collection<ApprenantEntity> apprenantsByIdformateur;
    private UsersEntity usersByIduser;
    private SpecialiteEntity specialiteByIdspecialite;

    public FormateurEntity() {

    }

//    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idformateur")
    public long getIdformateur() {
        return idformateur;
    }
    public void setIdformateur(Long idformateur) {
        this.idformateur = idformateur;
    }


    public FormateurEntity(String nom, String prenom, String cin, String email, String password, String role, Long idSpecialite) {
        super(nom, prenom, cin, email, password, role);
        this.idspecialite = idSpecialite;
    }


    @Basic
    @Column(name = "idspecialite")
    public Long getIdspecialite() {
        return idspecialite;
    }

    public void setIdspecialite(Long idspecialite) {
        this.idspecialite = idspecialite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormateurEntity that = (FormateurEntity) o;

        if (idformateur != that.idformateur) return false;
        if (iduser != null ? !iduser.equals(that.iduser) : that.iduser != null) return false;
        if (idspecialite != null ? !idspecialite.equals(that.idspecialite) : that.idspecialite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idformateur ^ (idformateur >>> 32));
        result = 31 * result + (iduser != null ? iduser.hashCode() : 0);
        result = 31 * result + (idspecialite != null ? idspecialite.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "formateurByIdformateur")
    public Collection<ApprenantEntity> getApprenantsByIdformateur() {
        return apprenantsByIdformateur;
    }

    public void setApprenantsByIdformateur(Collection<ApprenantEntity> apprenantsByIdformateur) {
        this.apprenantsByIdformateur = apprenantsByIdformateur;
    }

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser" , insertable = false, updatable = false)
    public UsersEntity getUsersByIduser() {
        return usersByIduser;
    }

    public void setUsersByIduser(UsersEntity usersByIduser) {
        this.usersByIduser = usersByIduser;
    }

    @ManyToOne
    @JoinColumn(name = "idspecialite", referencedColumnName = "idspecialite" , insertable = false, updatable = false)
    public SpecialiteEntity getSpecialiteByIdspecialite() {
        return specialiteByIdspecialite;
    }

    public void setSpecialiteByIdspecialite(SpecialiteEntity specialiteByIdspecialite) {
        this.specialiteByIdspecialite = specialiteByIdspecialite;
    }
}
//
//    public void setIdformateur(long idformateur) {
//        this.idformateur = idformateur;
//    }

//    @Basic
//    @Column(name = "iduser")
//    public Long getIduser() {
//        return iduser;
//    }
//
//    public void setIduser(Long iduser) {
//        this.iduser = iduser;
//    }