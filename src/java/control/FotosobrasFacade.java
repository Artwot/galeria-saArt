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
import modelo.Fotosobras;

/**
 *
 * @author jsarabia
 */
@Stateless
public class FotosobrasFacade extends AbstractFacade<Fotosobras> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosobrasFacade() {
        super(Fotosobras.class);
    }
    
    public List<Fotosobras> consultarFotosobras()
    {
        Query consulta= em.createNamedQuery("Fotosobras.activos", Fotosobras.class);
        List<Fotosobras> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
    public List<Fotosobras> consultarEliminados()
    {
        Query consulta= em.createNamedQuery("Fotosobras.eliminados", Fotosobras.class);
        List<Fotosobras> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
    }
    
}
