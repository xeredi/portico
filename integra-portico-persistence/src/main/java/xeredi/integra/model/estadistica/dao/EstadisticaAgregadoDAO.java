package xeredi.integra.model.estadistica.dao;

import java.util.List;

import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaAgregadoDAO.
 */
public interface EstadisticaAgregadoDAO {

    /**
     * Select actividad pesquera.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectActividadPesquera(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select avituallamiento.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAvituallamiento(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion superficie.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionSuperficie(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion escala.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionEscala(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento tipo buque eee.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoTipoBuqueEEE(final EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select buque fondeado atracado.
     * 
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectBuqueFondeadoAtracado(final EstadisticaAgregadoCriterioVO esagCriterioVO);

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
