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
import modelo.Exhibiciones;

/**
 *
 * @author jsarabia
 */
@Stateless
public class ExhibicionesFacade extends AbstractFacade<Exhibiciones> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExhibicionesFacade() {
        super(Exhibiciones.class);
    }
    
    public List<Exhibiciones> consultarExhibiciones()
    {
        Query consulta= em.createNamedQuery("Exhibiciones.activos", Exhibiciones.class);
        List<Exhibiciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Exhibiciones> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Exhibiciones.eliminados", Exhibiciones.class);
        List<Exhibiciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
