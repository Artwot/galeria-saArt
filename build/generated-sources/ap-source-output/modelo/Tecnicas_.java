package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Tecnicas.class)
public class Tecnicas_ { 

    public static volatile SingularAttribute<Tecnicas, String> descripcion;
    public static volatile CollectionAttribute<Tecnicas, Obras> obrasCollection;
    public static volatile SingularAttribute<Tecnicas, Integer> id;
    public static volatile SingularAttribute<Tecnicas, String> nombre;
    public static volatile SingularAttribute<Tecnicas, Integer> status;

}