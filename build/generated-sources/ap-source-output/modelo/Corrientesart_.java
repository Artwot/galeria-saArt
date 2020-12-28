package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T13:27:35")
@StaticMetamodel(Corrientesart.class)
public class Corrientesart_ { 

    public static volatile SingularAttribute<Corrientesart, String> descripcion;
    public static volatile SingularAttribute<Corrientesart, String> periodo;
    public static volatile CollectionAttribute<Corrientesart, Obras> obrasCollection;
    public static volatile SingularAttribute<Corrientesart, Integer> id;
    public static volatile SingularAttribute<Corrientesart, String> nombre;
    public static volatile SingularAttribute<Corrientesart, Integer> status;

}