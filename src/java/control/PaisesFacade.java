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
import modelo.Paises;

/**
 *
 * @author jsarabia
 */
@Stateless
public class PaisesFacade extends AbstractFacade<Paises> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisesFacade() {
        super(Paises.class);
    }

    public List<Paises> consultarPaises() {
        Query consulta = em.createNamedQuery("Paises.activos", Paises.class);
        List<Paises> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    public List<Paises> consultarEliminados() {
        Query consulta = em.createNamedQuery("Paises.eliminados", Paises.class);
        List<Paises> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

}
