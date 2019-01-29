package pkg_RMI_servidor;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pkg_RMI_servidor.DetalleCuda;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-01-29T02:59:14")
@StaticMetamodel(LibroCuda.class)
public class LibroCuda_ { 

    public static volatile ListAttribute<LibroCuda, DetalleCuda> detalleCudaList;
    public static volatile SingularAttribute<LibroCuda, Integer> isbnLibro;
    public static volatile SingularAttribute<LibroCuda, Integer> codigoAutor;
    public static volatile SingularAttribute<LibroCuda, Long> valorLibro;
    public static volatile SingularAttribute<LibroCuda, String> tituloLibro;
    public static volatile SingularAttribute<LibroCuda, Integer> cantidadLibro;

}