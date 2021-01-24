package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Estilos.class)
public class Estilos_ { 

    public static volatile SingularAttribute<Estilos, String> descripcion;
    public static volatile CollectionAttribute<Estilos, Obras> obrasCollection;
    public static volatile SingularAttribute<Estilos, Integer> id;
    public static volatile SingularAttribute<Estilos, String> nombre;
    public static volatile SingularAttribute<Estilos, Integer> status;

}