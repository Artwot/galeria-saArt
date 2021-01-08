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
import modelo.Obrasenexhibicion;

/**
 *
 * @author jsarabia
 */
@Stateless
public class ObrasenexhibicionFacade extends AbstractFacade<Obrasenexhibicion> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObrasenexhibicionFacade() {
        super(Obrasenexhibicion.class);
    }
    
    public List<Obrasenexhibicion> consultarObrasenexhibicion()
    {
        Query consulta= em.createNamedQuery("Obrasenexhibicion.activos", Obrasenexhibicion.class);
        List<Obrasenexhibicion> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Obrasenexhibicion> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Obrasenexhibicion.eliminados", Obrasenexhibicion.class);
        List<Obrasenexhibicion> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
