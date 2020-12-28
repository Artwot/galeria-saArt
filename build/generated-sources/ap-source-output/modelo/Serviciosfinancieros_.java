package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Tarjetascliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T13:27:35")
@StaticMetamodel(Serviciosfinancieros.class)
public class Serviciosfinancieros_ { 

    public static volatile SingularAttribute<Serviciosfinancieros, Integer> id;
    public static volatile SingularAttribute<Serviciosfinancieros, String> nombre;
    public static volatile CollectionAttribute<Serviciosfinancieros, Tarjetascliente> tarjetasclienteCollection;
    public static volatile SingularAttribute<Serviciosfinancieros, Integer> status;

}