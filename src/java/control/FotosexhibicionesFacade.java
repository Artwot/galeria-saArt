/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Fotosexhibiciones;

/**
 *
 * @author jsarabia
 */
@Stateless
public class FotosexhibicionesFacade extends AbstractFacade<Fotosexhibiciones> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosexhibicionesFacade() {
        super(Fotosexhibiciones.class);
    }
    
    public List<Fotosexhibiciones> consultarFotosexhibiciones()
    {
        Query consulta= em.createNamedQuery("Fotosexhibiciones.activos", Fotosexhibiciones.class);
        List<Fotosexhibiciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Fotosexhibiciones> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Fotosexhibiciones.eliminados", Fotosexhibiciones.class);
        List<Fotosexhibiciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
}
