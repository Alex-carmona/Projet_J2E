/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Lignecmd;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alex
 */
@Local
public interface LignecmdFacadeLocal {

    void create(Lignecmd lignecmd);

    void edit(Lignecmd lignecmd);

    void remove(Lignecmd lignecmd);

    Lignecmd find(Object id);

    List<Lignecmd> findAll();

    List<Lignecmd> findRange(int[] range);

    int count();
    
}
