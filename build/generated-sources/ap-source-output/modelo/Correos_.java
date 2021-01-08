package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(Correos.class)
public class Correos_ { 

    public static volatile SingularAttribute<Correos, Date> fecha;
    public static volatile SingularAttribute<Correos, String> contenido;
    public static volatile SingularAttribute<Correos, Usuarios> idUsuRemitente;
    public static volatile SingularAttribute<Correos, Integer> id;
    public static volatile SingularAttribute<Correos, String> destinatario;
    public static volatile SingularAttribute<Correos, Integer> status;

}