package xeredi.argo.model.servicio.dao;

// TODO: Auto-generated Javadoc
/**
 * DAO de acceso a los actores de un servicio..
 */
public interface ServicioActorDAO {

    /**
     * Borrado de los actores de un servicio.
     *
     * @param srvcId
     *            Identificador de servicio.
     * @return Número de actores de servicio eliminados.
     */
    int deleteList(final Long srvcId);

    /**
     * Inserción de los actores de un servicio.
     *
     * @param srvcId
     *            Identificador de servicio.
     */
    void insert(final Long srvcId);

    void insertAll();
}
