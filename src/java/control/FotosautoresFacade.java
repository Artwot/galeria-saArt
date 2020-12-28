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
import modelo.Fotosautores;

/**
 *
 * @author jsarabia
 */
@Stateless
public class FotosautoresFacade extends AbstractFacade<Fotosautores> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosautoresFacade() {
        super(Fotosautores.class);
    }

    public List<Fotosautores> consultarFotosautores() {
        Query consulta = em.createNamedQuery("Fotosautores.activos", Fotosautores.class);
        List<Fotosautores> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    public List<Fotosautores> consultarEliminados() {
        Query consulta = em.createNamedQuery("Fotosautores.eliminados", Fotosautores.class);
        List<Fotosautores> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }
    
    

}
