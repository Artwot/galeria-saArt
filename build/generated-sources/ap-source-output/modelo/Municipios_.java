package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Galerias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T13:27:35")
@StaticMetamodel(Municipios.class)
public class Municipios_ { 

    public static volatile SingularAttribute<Municipios, Entidades> idEntidad;
    public static volatile CollectionAttribute<Municipios, Galerias> galeriasCollection;
    public static volatile SingularAttribute<Municipios, Integer> id;
    public static volatile SingularAttribute<Municipios, String> nombre;
    public static volatile SingularAttribute<Municipios, Integer> status;

}