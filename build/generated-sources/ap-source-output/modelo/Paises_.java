package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Galerias;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile SingularAttribute<Paises, String> clave;
    public static volatile CollectionAttribute<Paises, Galerias> galeriasCollection;
    public static volatile CollectionAttribute<Paises, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Paises, Integer> id;
    public static volatile SingularAttribute<Paises, String> nombre;
    public static volatile CollectionAttribute<Paises, Entidades> entidadesCollection;
    public static volatile SingularAttribute<Paises, Integer> status;

}