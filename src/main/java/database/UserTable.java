/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes Eifert
 */
@Entity
@Table(name = "UserTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u"),
    @NamedQuery(name = "UserTable.findByIdUser", query = "SELECT u FROM UserTable u WHERE u.idUser = :idUser")})
public class UserTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic(optional = false)
    @Lob
    @Column(name = "sport_username")
    private String sportUsername;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "doodle_username")
    private String doodleUsername;
    @Lob
    @Column(name = "doodle_password")
    private String doodlePassword;

    public UserTable() {
    }

    public UserTable(Integer idUser) {
        this.idUser = idUser;
    }

    public UserTable(Integer idUser, String sportUsername, String password) {
        this.idUser = idUser;
        this.sportUsername = sportUsername;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getSportUsername() {
        return sportUsername;
    }

    public void setSportUsername(String sportUsername) {
        this.sportUsername = sportUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoodleUsername() {
        return doodleUsername;
    }

    public void setDoodleUsername(String doodleUsername) {
        this.doodleUsername = doodleUsername;
    }

    public String getDoodlePassword() {
        return doodlePassword;
    }

    public void setDoodlePassword(String doodlePassword) {
        this.doodlePassword = doodlePassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTable)) {
            return false;
        }
        UserTable other = (UserTable) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UserTable[ idUser=" + idUser + " ]";
    }
    
}
