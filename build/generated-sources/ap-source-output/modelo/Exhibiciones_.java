package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Boletosexhibicion;
import modelo.Fotosexhibiciones;
import modelo.Galerias;
import modelo.Obrasenexhibicion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-08T13:36:16")
@StaticMetamodel(Exhibiciones.class)
public class Exhibiciones_ { 

    public static volatile SingularAttribute<Exhibiciones, String> descripcion;
    public static volatile SingularAttribute<Exhibiciones, Date> fechaInicio;
    public static volatile SingularAttribute<Exhibiciones, Galerias> idGaleria;
    public static volatile CollectionAttribute<Exhibiciones, Fotosexhibiciones> fotosexhibicionesCollection;
    public static volatile SingularAttribute<Exhibiciones, Integer> id;
    public static volatile SingularAttribute<Exhibiciones, String> nombre;
    public static volatile SingularAttribute<Exhibiciones, Date> fechaFin;
    public static volatile SingularAttribute<Exhibiciones, Integer> status;
    public static volatile CollectionAttribute<Exhibiciones, Obrasenexhibicion> obrasenexhibicionCollection;
    public static volatile CollectionAttribute<Exhibiciones, Boletosexhibicion> boletosexhibicionCollection;

}