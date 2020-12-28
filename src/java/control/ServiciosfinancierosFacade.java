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
import modelo.Serviciosfinancieros;

/**
 *
 * @author jsarabia
 */
@Stateless
public class ServiciosfinancierosFacade extends AbstractFacade<Serviciosfinancieros> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciosfinancierosFacade() {
        super(Serviciosfinancieros.class);
    }

    public List<Serviciosfinancieros> consultarServiciosfinancieros() {
        Query consulta = em.createNamedQuery("Serviciosfinancieros.activos", Serviciosfinancieros.class);
        List<Serviciosfinancieros> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    public List<Serviciosfinancieros> consultarEliminados() {
        Query consulta = em.createNamedQuery("Serviciosfinancieros.eliminados", Serviciosfinancieros.class);
        List<Serviciosfinancieros> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

}
