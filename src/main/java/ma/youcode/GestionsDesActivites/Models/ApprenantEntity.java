package ma.youcode.GestionsDesActivites.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "apprenant", schema = "public")
@PrimaryKeyJoinColumn(name = "idUser")
public class ApprenantEntity extends UsersEntity{

    private long idapprenant;
    private Long iduser;
    private Long idformateur;
    private boolean isbde;
    private UsersEntity usersByIduser;
    private FormateurEntity formateurByIdformateur;

    public ApprenantEntity() {
        super();
    }

    public ApprenantEntity(String nom, String prenom, String cin, String email, String password, String role, Long idformateur, boolean isbde) {
        super(nom, prenom, cin, email, password, role);
        this.idformateur = idformateur;
        this.isbde = isbde;
    }

//     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idapprenant")
    public long getIdapprenant() {
        return idapprenant;
    }

    public void setIdapprenant(long idapprenant) {
        this.idapprenant = idapprenant;
    }


    @Basic
    @Column(name = "idformateur")
    public Long getIdformateur() {
        return idformateur;
    }

    public void setIdformateur(Long idformateur) {
        this.idformateur = idformateur;
    }

    @Basic
    @Column(name = "isbde")
    public boolean isIsbde() {
        return isbde;
    }

    public void setIsbde(boolean isbde) {
        this.isbde = isbde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (idapprenant != that.idapprenant) return false;
        if (isbde != that.isbde) return false;
        if (iduser != null ? !iduser.equals(that.iduser) : that.iduser != null) return false;
        if (idformateur != null ? !idformateur.equals(that.idformateur) : that.idformateur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idapprenant ^ (idapprenant >>> 32));
        result = 31 * result + (iduser != null ? iduser.hashCode() : 0);
        result = 31 * result + (idformateur != null ? idformateur.hashCode() : 0);
        result = 31 * result + (isbde ? 1 : 0);
        return result;
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
    @JoinColumn(name = "idformateur", referencedColumnName = "idformateur" , insertable = false, updatable = false)
    public FormateurEntity getFormateurByIdformateur() {
        return formateurByIdformateur;
    }

    public void setFormateurByIdformateur(FormateurEntity formateurByIdformateur) {
        this.formateurByIdformateur = formateurByIdformateur;
    }
}
