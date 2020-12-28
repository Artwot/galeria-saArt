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
import modelo.Galerias;

/**
 *
 * @author jsarabia
 */
@Stateless
public class GaleriasFacade extends AbstractFacade<Galerias> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GaleriasFacade() {
        super(Galerias.class);
    }
    
    public List<Galerias> consultarGalerias()
    {
        Query consulta= em.createNamedQuery("Galerias.activos", Galerias.class);
        List<Galerias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Galerias> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Galerias.eliminados", Galerias.class);
        List<Galerias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
