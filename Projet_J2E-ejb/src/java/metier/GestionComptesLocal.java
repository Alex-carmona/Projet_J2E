/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Local;
import services.Position;

/**
 *
 * @author Patrice Torguet
 */
@Local
public interface GestionComptesLocal {

    public void ajouter(long idCompte, float somme) throws exceptions.CompteInconnuException;

    public void retirer(long idCompte, float somme) throws exceptions.CompteInconnuException, exceptions.SoldeInsuffisantException;
    
    public Position position(long idCompte) throws exceptions.CompteInconnuException;
    
}
