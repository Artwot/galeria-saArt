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
import modelo.Tiposobra;

/**
 *
 * @author jsarabia
 */
@Stateless
public class TiposobraFacade extends AbstractFacade<Tiposobra> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposobraFacade() {
        super(Tiposobra.class);
    }
    
    public List<Tiposobra> consultarTiposobra()
    {
        Query consulta= em.createNamedQuery("Tiposobra.activos", Tiposobra.class);
        List<Tiposobra> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Tiposobra> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Tiposobra.eliminados", Tiposobra.class);
        List<Tiposobra> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
