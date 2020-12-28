package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Autores;
import modelo.Corrientesart;
import modelo.DetalleVenta;
import modelo.Estilos;
import modelo.Fotosobras;
import modelo.Obrasenexhibicion;
import modelo.Tecnicas;
import modelo.Tiposobra;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T13:27:35")
@StaticMetamodel(Obras.class)
public class Obras_ { 

    public static volatile SingularAttribute<Obras, String> descripcion;
    public static volatile SingularAttribute<Obras, Tecnicas> idTecnica;
    public static volatile SingularAttribute<Obras, String> medidas;
    public static volatile SingularAttribute<Obras, String> nombre;
    public static volatile SingularAttribute<Obras, Double> precio;
    public static volatile SingularAttribute<Obras, Estilos> idEstilo;
    public static volatile SingularAttribute<Obras, Corrientesart> idCorriente;
    public static volatile SingularAttribute<Obras, Autores> idAutor;
    public static volatile SingularAttribute<Obras, Date> anioCreacion;
    public static volatile SingularAttribute<Obras, Tiposobra> idTipo;
    public static volatile CollectionAttribute<Obras, Fotosobras> fotosobrasCollection;
    public static volatile SingularAttribute<Obras, Integer> id;
    public static volatile SingularAttribute<Obras, Integer> stock;
    public static volatile SingularAttribute<Obras, Integer> status;
    public static volatile CollectionAttribute<Obras, DetalleVenta> detalleVentaCollection;
    public static volatile CollectionAttribute<Obras, Obrasenexhibicion> obrasenexhibicionCollection;

}