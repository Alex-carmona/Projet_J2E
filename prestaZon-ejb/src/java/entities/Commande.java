/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande")
    , @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMMANDE")
    private Integer idcommande;
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "IDSTATUT", referencedColumnName = "IDSTATUT")
    @ManyToOne(optional = false)
    private Statut idstatut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommande")
    private Collection<Lignecmd> lignecmdCollection;

    public Commande() {
    }

    public Commande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Statut getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Statut idstatut) {
        this.idstatut = idstatut;
    }

    @XmlTransient
    public Collection<Lignecmd> getLignecmdCollection() {
        return lignecmdCollection;
    }

    public void setLignecmdCollection(Collection<Lignecmd> lignecmdCollection) {
        this.lignecmdCollection = lignecmdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ idcommande=" + idcommande + " ]";
    }
    
}
