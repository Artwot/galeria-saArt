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
import org.apache.commons.codec.digest.DigestUtils;

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

    public String consultarUsername(String username) {
        System.out.println("#####################Estás en el Facade############################");
        String consulta = "";
        Query query = em.createNamedQuery("Usuarios.userName", Usuarios.class)
                .setParameter("username", username);
        username = "[" +username +"]";
        /*System.out.println("Nombre de usuario: " + username);
        System.out.println("Query: " +query.getResultList().toString());
        System.out.println("Valor: " +query.equals(username));*/
        if (query.getResultList().toString().equals(username)) {
            System.out.println("Esto ha funcionado.");
            consulta = "Nombre de usuario no disponible.";
            return consulta;
        } else {
            consulta = "Nombre de usuario disponible";
            return consulta;
        }
    }
    
    public Usuarios Buscar(String username, String password) {
        String pass_encrip = DigestUtils.sha1Hex(password);
        System.out.println("Encriptada: " +pass_encrip);
        Query consulta = em.createNamedQuery("Usuarios.buscar", Usuarios.class)
                .setParameter("username", username)
                .setParameter("password", pass_encrip);
        List<Usuarios> lista = consulta.getResultList();
        System.out.println("USUNAME: " + lista.toString());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

}
