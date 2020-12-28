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
import modelo.Obras;

/**
 *
 * @author jsarabia
 */
@Stateless
public class ObrasFacade extends AbstractFacade<Obras> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObrasFacade() {
        super(Obras.class);
    }

    public List<Obras> consultarObras() {
        Query consulta = em.createNamedQuery("Obras.activos", Obras.class);
        List<Obras> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    public List<Obras> consultarEliminados() {
        Query consulta = em.createNamedQuery("Obras.eliminados", Obras.class);
        List<Obras> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

}
