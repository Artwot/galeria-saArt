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
import modelo.Correos;

/**
 *
 * @author jsarabia
 */
@Stateless
public class CorreosFacade extends AbstractFacade<Correos> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreosFacade() {
        super(Correos.class);
    }
    
    public List<Correos> consultarCorreos()
    {
        Query consulta= em.createNamedQuery("Correos.activos", Correos.class);
        List<Correos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Correos> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Correos.eliminados", Correos.class);
        List<Correos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
