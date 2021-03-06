package xeredi.argo.model.estadistica.dao;

import java.util.List;

import xeredi.argo.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaAgregadoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaAgregadoDAO.
 */
public interface EstadisticaAgregadoDAO {
    /**
     * Update srvc actividad pesquera.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcActividadPesquera(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select actividad pesquera.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectActividadPesquera(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc avituallamiento.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAvituallamiento(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select avituallamiento.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAvituallamiento(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc agregacion superficie.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAgregacionSuperficie(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion superficie.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionSuperficie(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc agregacion escala.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAgregacionEscala(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion escala.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionEscala(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc movimiento tipo buque eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcMovimientoTipoBuqueEEE(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento tipo buque eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoTipoBuqueEEE(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc buque fondeado atracado.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcBuqueFondeadoAtracado(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select buque fondeado atracado.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectBuqueFondeadoAtracado(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc movimiento mercancia.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcMovimientoMercancia(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento mercancia.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoMercancia(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento mercancia eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoMercanciaEEE(final EstadisticaAgregadoCriterioVO esagCriterioVO);
}
