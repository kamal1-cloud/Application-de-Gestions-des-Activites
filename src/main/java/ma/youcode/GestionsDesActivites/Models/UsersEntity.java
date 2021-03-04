package ma.youcode.GestionsDesActivites.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class UsersEntity implements Serializable{
    private long iduser;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String password;
    private String role;
    private Collection<ApprenantEntity> apprenantsByIduser;
    private Collection<EventsEntity> eventsByIduser;
    private Collection<FormateurEntity> formateursByIduser;

    public UsersEntity(String nom, String prenom, String cin, String email, String password, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UsersEntity() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
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
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "cin")
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (iduser != that.iduser) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (cin != null ? !cin.equals(that.cin) : that.cin != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (iduser ^ (iduser >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByIduser")
    public Collection<ApprenantEntity> getApprenantsByIduser() {
        return apprenantsByIduser;
    }

    public void setApprenantsByIduser(Collection<ApprenantEntity> apprenantsByIduser) {
        this.apprenantsByIduser = apprenantsByIduser;
    }

    @OneToMany(mappedBy = "usersByOrganisateur")
    public Collection<EventsEntity> getEventsByIduser() {
        return eventsByIduser;
    }

    public void setEventsByIduser(Collection<EventsEntity> eventsByIduser) {
        this.eventsByIduser = eventsByIduser;
    }

    @OneToMany(mappedBy = "usersByIduser")
    public Collection<FormateurEntity> getFormateursByIduser() {
        return formateursByIduser;
    }

    public void setFormateursByIduser(Collection<FormateurEntity> formateursByIduser) {
        this.formateursByIduser = formateursByIduser;
    }
}
