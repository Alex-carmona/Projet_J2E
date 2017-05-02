/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionClientLocal;
import metier.GestionComptesLocal;

/**
 *
 * @author Patrice Torguet
 */
@Stateless
public class ServiceBanque implements ServiceBanqueRemote {

    @EJB
    private GestionComptesLocal gestionComptes;

    @EJB
    private GestionClientLocal gestionClient;
    
    

    @Override
    public long creerClient(String nom, String prenom) throws exceptions.ClientExistantException {
        return gestionClient.creerClient(nom, prenom);
    }

    @Override
    public long chercherClient(String nom, String prenom) throws exceptions.ClientInconnuException {
        return gestionClient.chercherClient(nom, prenom);
    }

    @Override
    public List<Long> listeNumComptes(long idClient) throws exceptions.ClientInconnuException{
        return gestionClient.listeNumComptes(idClient);
    }

    @Override
    public long creerCompte(long idClient) throws exceptions.ClientInconnuException {
        return gestionClient.creerCompte(idClient);
    }

    @Override
    public void ajouter(long idCompte, float somme) throws exceptions.CompteInconnuException {
        this.gestionComptes.ajouter(idCompte, somme);
    }

    @Override
    public void retirer(long idCompte, float somme) throws exceptions.CompteInconnuException, exceptions.SoldeInsuffisantException {
        this.gestionComptes.retirer(idCompte, somme);
    }

    @Override
    public Position position(long idCompte) throws exceptions.CompteInconnuException {
        return this.gestionComptes.position(idCompte);
    }
    
}
