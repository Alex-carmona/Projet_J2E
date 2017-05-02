/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patrice Torguet
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> 
        implements ClientFacadeLocal {

    @PersistenceContext(unitName = "TPBanqueApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public long chercherClient(String nom, String prenom) throws exceptions.ClientInconnuException {
        try {
            Query q = em.createQuery(
               "select c from Client c where c.nom = :nom and c.prenom = :prenom");
            q.setParameter("nom", nom);
            q.setParameter("prenom", prenom);
            Client c = (Client) q.getSingleResult();
            return c.getId();
        } catch(NoResultException e) {
            throw new exceptions.ClientInconnuException();
        }
    }
    
    
    
}
