package metier;

import controllers.CompteFacadeLocal;
import controllers.OperationFacadeLocal;
import entities.Compte;
import entities.Operation;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import services.Position;

@Stateless
public class GestionComptes implements GestionComptesLocal {

    @EJB
    private OperationFacadeLocal operationFacade;

    @EJB
    private CompteFacadeLocal compteFacade;
    @Override
    public void ajouter(long idCompte, float somme) throws exceptions.CompteInconnuException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new exceptions.CompteInconnuException();
        c.setSolde(c.getSolde()+somme);
        Operation op = new Operation();
        op.setCompte(c);
        op.setType("CREDIT");
        op.setSomme(somme);
        op.setDate(new Date());
        operationFacade.create(op);
    }

    @Override
    public void retirer(long idCompte, float somme)  throws exceptions.CompteInconnuException, exceptions.SoldeInsuffisantException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new exceptions.CompteInconnuException();
        if (c.getSolde() < somme)
            throw new exceptions.SoldeInsuffisantException();
        
        c.setSolde(c.getSolde()-somme);
        Operation op = new Operation();
        op.setCompte(c);
        op.setType("DEBIT");
        op.setSomme(somme);
        op.setDate(new Date());
        operationFacade.create(op);
    }
    
    @Override
    public Position position(long idCompte) throws exceptions.CompteInconnuException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new exceptions.CompteInconnuException();
        Position p = new Position();
        p.setIdComte(idCompte);
        p.setDate(new Date());
        p.setSolde(c.getSolde());
        return p;
    }
    
}
