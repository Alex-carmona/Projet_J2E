/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patrice Torguet
 */
@Local
public interface GestionClientLocal {

    long creerClient(String nom, String prenom) throws exceptions.ClientExistantException;

    long chercherClient(String nom, String prenom) throws exceptions.ClientInconnuException;

    List<Long> listeNumComptes(long idClient) throws exceptions.ClientInconnuException;

    long creerCompte(long idClient) throws exceptions.ClientInconnuException;
    
}
