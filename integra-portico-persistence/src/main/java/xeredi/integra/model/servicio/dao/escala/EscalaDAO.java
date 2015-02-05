package xeredi.integra.model.servicio.dao.escala;

import javax.annotation.Nonnull;

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
    String selectNumeroManifiestoAeat(final @Nonnull Long srvcId);

    /**
     * Modificacion del estado de una escala a partir del estado de sus atraques.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateEstado(final @Nonnull Long srvcId);

    /**
     * Modificacion del codigo de exencion de una escala a partir del codigo de exencion de sus atraques.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateExencion(final @Nonnull Long srvcId);

    /**
     * Modificacion del tipo de estancia de una escala a partir del tipo de estancia de sus atraques.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateEstancia(final @Nonnull Long srvcId);

    /**
     * Modificacion del tipo de navegacion de entrada de una escala a partir del puerto anterior.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateNavegacionEntrada(final @Nonnull Long srvcId);

    /**
     * Modificacion del tipo de navegacion de salida de una escala a partir del puerto siguiente.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateNavegacionSalida(final @Nonnull Long srvcId);

    /**
     * Modificacion del tipo de IVA de una escala a partir de datos de la escala.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateTipoIva(final @Nonnull Long srvcId);

    /**
     * Modificacion de las fechas de inicio/fin de una escala a partir las fechas de inicio/fin de sus
     * atraques.
     *
     * @param srvcId
     *            Identificador del servicio de escala.
     * @return Numero de filas modificadas.
     */
    int updateFechaInicioFin(final @Nonnull Long srvcId);
}
