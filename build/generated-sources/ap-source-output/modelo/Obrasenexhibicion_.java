package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Exhibiciones;
import modelo.Obras;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T13:27:35")
@StaticMetamodel(Obrasenexhibicion.class)
public class Obrasenexhibicion_ { 

    public static volatile SingularAttribute<Obrasenexhibicion, Exhibiciones> idExhibicion;
    public static volatile SingularAttribute<Obrasenexhibicion, Integer> id;
    public static volatile SingularAttribute<Obrasenexhibicion, Obras> idObra;
    public static volatile SingularAttribute<Obrasenexhibicion, Integer> status;

}