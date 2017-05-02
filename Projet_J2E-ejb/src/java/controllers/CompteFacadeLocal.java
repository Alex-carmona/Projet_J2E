/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Compte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patrice Torguet
 */
@Local
public interface CompteFacadeLocal {

    Object create(Compte compte);

    void edit(Compte compte);

    void remove(Compte compte);

    Compte find(Object id);

    List<Compte> findAll();

    List<Compte> findRange(int[] range);

    int count();
    
}
