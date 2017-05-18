/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "STATUT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statut.findAll", query = "SELECT s FROM Statut s")
    , @NamedQuery(name = "Statut.findByIdstatut", query = "SELECT s FROM Statut s WHERE s.idstatut = :idstatut")
    , @NamedQuery(name = "Statut.findByLibstatut", query = "SELECT s FROM Statut s WHERE s.libstatut = :libstatut")})
public class Statut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSTATUT")
    private Integer idstatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LIBSTATUT")
    private String libstatut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstatut")
    private Collection<Commande> commandeCollection;

    public Statut() {
    }

    public Statut(Integer idstatut) {
        this.idstatut = idstatut;
    }

    public Statut(Integer idstatut, String libstatut) {
        this.idstatut = idstatut;
        this.libstatut = libstatut;
    }

    public Integer getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Integer idstatut) {
        this.idstatut = idstatut;
    }

    public String getLibstatut() {
        return libstatut;
    }

    public void setLibstatut(String libstatut) {
        this.libstatut = libstatut;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstatut != null ? idstatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.idstatut == null && other.idstatut != null) || (this.idstatut != null && !this.idstatut.equals(other.idstatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statut[ idstatut=" + idstatut + " ]";
    }
    
}
