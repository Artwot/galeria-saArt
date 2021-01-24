package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Exhibiciones;
import modelo.Municipios;
import modelo.Paises;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-23T18:48:40")
@StaticMetamodel(Galerias.class)
public class Galerias_ { 

    public static volatile SingularAttribute<Galerias, Integer> numExt;
    public static volatile SingularAttribute<Galerias, String> horario;
    public static volatile SingularAttribute<Galerias, Paises> idPais;
    public static volatile SingularAttribute<Galerias, String> calle;
    public static volatile SingularAttribute<Galerias, Municipios> idMunicipio;
    public static volatile SingularAttribute<Galerias, String> nombre;
    public static volatile SingularAttribute<Galerias, Integer> cp;
    public static volatile SingularAttribute<Galerias, String> colonia;
    public static volatile SingularAttribute<Galerias, Entidades> idEntidad;
    public static volatile SingularAttribute<Galerias, String> web;
    public static volatile CollectionAttribute<Galerias, Exhibiciones> exhibicionesCollection;
    public static volatile SingularAttribute<Galerias, Integer> id;
    public static volatile SingularAttribute<Galerias, String> telefono;
    public static volatile SingularAttribute<Galerias, Integer> status;

}