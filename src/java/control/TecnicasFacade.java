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
import modelo.Tecnicas;

/**
 *
 * @author jsarabia
 */
@Stateless
public class TecnicasFacade extends AbstractFacade<Tecnicas> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicasFacade() {
        super(Tecnicas.class);
    }
    
    public List<Tecnicas> consultarTecnicas()
    {
        Query consulta= em.createNamedQuery("Tecnicas.activos", Tecnicas.class);
        List<Tecnicas> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Tecnicas> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Tecnicas.eliminados", Tecnicas.class);
        List<Tecnicas> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
