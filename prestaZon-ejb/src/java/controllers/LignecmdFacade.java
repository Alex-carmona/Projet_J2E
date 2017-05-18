/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Lignecmd;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class LignecmdFacade extends AbstractFacade<Lignecmd> implements LignecmdFacadeLocal {

    @PersistenceContext(unitName = "prestaZon-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LignecmdFacade() {
        super(Lignecmd.class);
    }
    
}
