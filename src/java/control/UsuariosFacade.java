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
import modelo.Usuarios;

/**
 *
 * @author jsarabia
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "GaleriaSaArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public List<Usuarios> consultarUsuarios() {
        Query consulta = em.createNamedQuery("Usuarios.activos", Usuarios.class);
        List<Usuarios> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    public List<Usuarios> consultarEliminados() {
        Query consulta = em.createNamedQuery("Usuarios.eliminados", Usuarios.class);
        List<Usuarios> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

}