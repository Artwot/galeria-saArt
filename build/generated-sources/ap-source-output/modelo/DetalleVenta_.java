package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envios;
import modelo.Obras;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile CollectionAttribute<DetalleVenta, Envios> enviosCollection;
    public static volatile SingularAttribute<DetalleVenta, Integer> id;
    public static volatile SingularAttribute<DetalleVenta, Integer> cantidad;
    public static volatile SingularAttribute<DetalleVenta, Double> precioVenta;
    public static volatile SingularAttribute<DetalleVenta, Obras> idObra;
    public static volatile SingularAttribute<DetalleVenta, Integer> status;
    public static volatile SingularAttribute<DetalleVenta, Ventas> idVenta;

}