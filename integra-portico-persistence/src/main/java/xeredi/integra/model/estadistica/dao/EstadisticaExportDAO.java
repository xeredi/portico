package xeredi.integra.model.estadistica.dao;

import java.util.List;

import xeredi.integra.model.estadistica.vo.EstadisticaExportVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaExportDAO.
 */
public interface EstadisticaExportDAO {

    /**
     * Select actividad pesquera.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectActividadPesquera(final Long peprId);

    /**
     * Select avituallamiento.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectAvituallamiento(final Long peprId);

    /**
     * Select agregacion escala.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectAgregacionEscala(final Long peprId);

    /**
     * Select movimiento mercancia.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectMovimientoMercancia(final Long peprId);

    /**
     * Select movimiento mercancia eee.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectMovimientoMercanciaEEE(final Long peprId);

    /**
     * Select movimiento tipo buque eee.
     *
     * @param peprId the pepr id
     * @return the list
     */
    List<EstadisticaExportVO> selectMovimientoTipoBuqueEEE(final Long peprId);
}
