package xeredi.integra.model.dao.servicio.escala;

// TODO: Auto-generated Javadoc
/**
 * The Interface EscalaDAO.
 */
public interface EscalaDAO {

    /**
     * Select numero manifiesto aeat.
     * 
     * @param srvcId
     *            the srvc id
     * @return the string
     */
    String selectNumeroManifiestoAeat(final Long srvcId);

    /**
     * Modificacion del estado de una escala a partir del estado de sus atraques.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateEstado(final Long srvcId);

    /**
     * Modificacion del codigo de exencion de una escala a partir del codigo de exencion de sus
     * atraques.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateExencion(final Long srvcId);

    /**
     * Modificacion del tipo de estancia de una escala a partir del tipo de estancia de sus
     * atraques.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateEstancia(final Long srvcId);

    /**
     * Modificacion del tipo de navegacion de entrada de una escala a partir del puerto anterior.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateNavegacionEntrada(final Long srvcId);

    /**
     * Modificacion del tipo de navegacion de salida de una escala a partir del puerto siguiente.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateNavegacionSalida(final Long srvcId);

    /**
     * Modificacion del tipo de IVA de una escala a partir de datos de la escala.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateTipoIva(final Long srvcId);

    /**
     * Modificacion de las fechas de inicio/fin de una escala a partir las fechas de inicio/fin de
     * sus atraques.
     * 
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateFechaInicioFin(final Long srvcId);
}
