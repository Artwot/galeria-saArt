package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(Tiposobra.class)
public class Tiposobra_ { 

    public static volatile SingularAttribute<Tiposobra, String> descripcion;
    public static volatile CollectionAttribute<Tiposobra, Obras> obrasCollection;
    public static volatile SingularAttribute<Tiposobra, Integer> id;
    public static volatile SingularAttribute<Tiposobra, String> nombre;
    public static volatile SingularAttribute<Tiposobra, Integer> status;

}