package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DetalleVenta;
import modelo.Paqueterias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(Envios.class)
public class Envios_ { 

    public static volatile SingularAttribute<Envios, String> descripcion;
    public static volatile SingularAttribute<Envios, Date> fechaEnvio;
    public static volatile SingularAttribute<Envios, Long> noGuia;
    public static volatile SingularAttribute<Envios, Date> fechaEntrega;
    public static volatile SingularAttribute<Envios, Paqueterias> idPaqueteria;
    public static volatile SingularAttribute<Envios, Integer> id;
    public static volatile SingularAttribute<Envios, Integer> status;
    public static volatile SingularAttribute<Envios, DetalleVenta> idVenta;

}