package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Paqueterias.class)
public class Paqueterias_ { 

    public static volatile SingularAttribute<Paqueterias, String> web;
    public static volatile CollectionAttribute<Paqueterias, Envios> enviosCollection;
    public static volatile SingularAttribute<Paqueterias, Integer> id;
    public static volatile SingularAttribute<Paqueterias, String> nombre;
    public static volatile SingularAttribute<Paqueterias, Integer> status;

}