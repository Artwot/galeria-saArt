package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Galerias;
import modelo.Municipios;
import modelo.Paises;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Entidades.class)
public class Entidades_ { 

    public static volatile CollectionAttribute<Entidades, Galerias> galeriasCollection;
    public static volatile SingularAttribute<Entidades, Paises> idPais;
    public static volatile CollectionAttribute<Entidades, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Entidades, Integer> id;
    public static volatile SingularAttribute<Entidades, String> nombre;
    public static volatile CollectionAttribute<Entidades, Municipios> municipiosCollection;
    public static volatile SingularAttribute<Entidades, Integer> status;

}