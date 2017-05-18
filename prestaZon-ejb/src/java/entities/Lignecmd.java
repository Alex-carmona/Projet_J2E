/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "LIGNECMD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecmd.findAll", query = "SELECT l FROM Lignecmd l")
    , @NamedQuery(name = "Lignecmd.findByIdligne", query = "SELECT l FROM Lignecmd l WHERE l.idligne = :idligne")
    , @NamedQuery(name = "Lignecmd.findByQte", query = "SELECT l FROM Lignecmd l WHERE l.qte = :qte")})
public class Lignecmd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLIGNE")
    private Integer idligne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTE")
    private int qte;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "IDCOMMANDE")
    @ManyToOne(optional = false)
    private Commande idcommande;
    @JoinColumn(name = "IDPRODUIT", referencedColumnName = "IDPRODUIT")
    @ManyToOne(optional = false)
    private Produit idproduit;

    public Lignecmd() {
    }

    public Lignecmd(Integer idligne) {
        this.idligne = idligne;
    }

    public Lignecmd(Integer idligne, int qte) {
        this.idligne = idligne;
        this.qte = qte;
    }

    public Integer getIdligne() {
        return idligne;
    }

    public void setIdligne(Integer idligne) {
        this.idligne = idligne;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idligne != null ? idligne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecmd)) {
            return false;
        }
        Lignecmd other = (Lignecmd) object;
        if ((this.idligne == null && other.idligne != null) || (this.idligne != null && !this.idligne.equals(other.idligne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lignecmd[ idligne=" + idligne + " ]";
    }
    
}
