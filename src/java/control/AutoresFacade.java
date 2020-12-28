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
import modelo.Autores;

/**
 *
 * @author jsarabia
 */
@Stateless
public class AutoresFacade extends AbstractFacade<Autores> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }
    
    public List<Autores> consultarAutores()
    {
        Query consulta= em.createNamedQuery("Autores.autoresActivos", Autores.class);
        List<Autores> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Autores> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Autores.autoresEliminados", Autores.class);
        List<Autores> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
