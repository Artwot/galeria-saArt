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
import modelo.Boletosexhibicion;

/**
 *
 * @author jsarabia
 */
@Stateless
public class BoletosexhibicionFacade extends AbstractFacade<Boletosexhibicion> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletosexhibicionFacade() {
        super(Boletosexhibicion.class);
    }
    
    public List<Boletosexhibicion> consultarBoletosexhibicion()
    {
        Query consulta= em.createNamedQuery("Boletosexhibicion.activos", Boletosexhibicion.class);
        List<Boletosexhibicion> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Boletosexhibicion> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Boletosexhibicion.eliminados", Boletosexhibicion.class);
        List<Boletosexhibicion> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
