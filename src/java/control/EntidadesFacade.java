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
import modelo.Entidades;

/**
 *
 * @author jsarabia
 */
@Stateless
public class EntidadesFacade extends AbstractFacade<Entidades> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadesFacade() {
        super(Entidades.class);
    }
    
    public List<Entidades> consultarEntidades()
    {
        Query consulta= em.createNamedQuery("Entidades.activos", Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Entidades> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Entidades.eliminados", Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
