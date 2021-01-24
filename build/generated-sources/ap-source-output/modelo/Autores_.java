package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Fotosautores;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Autores.class)
public class Autores_ { 

    public static volatile SingularAttribute<Autores, String> informacion;
    public static volatile SingularAttribute<Autores, String> apellido;
    public static volatile CollectionAttribute<Autores, Obras> obrasCollection;
    public static volatile CollectionAttribute<Autores, Fotosautores> fotosautoresCollection;
    public static volatile SingularAttribute<Autores, Integer> id;
    public static volatile SingularAttribute<Autores, String> nombre;
    public static volatile SingularAttribute<Autores, Boolean> autorHistorico;
    public static volatile SingularAttribute<Autores, Integer> status;

}