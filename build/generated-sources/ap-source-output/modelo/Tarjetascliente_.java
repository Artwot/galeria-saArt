package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Serviciosfinancieros;
import modelo.Usuarios;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Tarjetascliente.class)
public class Tarjetascliente_ { 

    public static volatile SingularAttribute<Tarjetascliente, String> nombrePropietario;
    public static volatile SingularAttribute<Tarjetascliente, Integer> cvv;
    public static volatile SingularAttribute<Tarjetascliente, Long> numero;
    public static volatile SingularAttribute<Tarjetascliente, Usuarios> idCliente;
    public static volatile SingularAttribute<Tarjetascliente, String> fechaExpiracion;
    public static volatile CollectionAttribute<Tarjetascliente, Ventas> ventasCollection;
    public static volatile SingularAttribute<Tarjetascliente, Integer> id;
    public static volatile SingularAttribute<Tarjetascliente, Serviciosfinancieros> idServicio;
    public static volatile SingularAttribute<Tarjetascliente, Integer> status;

}