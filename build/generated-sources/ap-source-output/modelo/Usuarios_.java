package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Correos;
import modelo.Entidades;
import modelo.Paises;
import modelo.Tarjetascliente;
import modelo.Tiposusuario;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Integer> noExt;
    public static volatile SingularAttribute<Usuarios, Date> fechaNaci;
    public static volatile SingularAttribute<Usuarios, Paises> idPais;
    public static volatile SingularAttribute<Usuarios, String> calle;
    public static volatile CollectionAttribute<Usuarios, Ventas> ventasCollection;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, Integer> cp;
    public static volatile CollectionAttribute<Usuarios, Tarjetascliente> tarjetasclienteCollection;
    public static volatile SingularAttribute<Usuarios, String> colonia;
    public static volatile CollectionAttribute<Usuarios, Ventas> ventasCollection1;
    public static volatile SingularAttribute<Usuarios, Entidades> idEntidad;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, Tiposusuario> idTipoUsu;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> apMat;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile CollectionAttribute<Usuarios, Correos> correosCollection;
    public static volatile SingularAttribute<Usuarios, String> apPat;
    public static volatile SingularAttribute<Usuarios, String> username;
    public static volatile SingularAttribute<Usuarios, Integer> status;

}