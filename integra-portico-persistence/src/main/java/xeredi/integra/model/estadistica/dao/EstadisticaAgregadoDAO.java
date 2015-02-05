package xeredi.integra.model.estadistica.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaAgregadoVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaAgregadoDAO.
 */
public interface EstadisticaAgregadoDAO {

    /**
     * Select subp ids.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<Long> selectSubpIds(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Update srvc actividad pesquera.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcActividadPesquera(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select actividad pesquera.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectActividadPesquera(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc avituallamiento.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAvituallamiento(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select avituallamiento.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAvituallamiento(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc agregacion superficie.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAgregacionSuperficie(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion superficie.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionSuperficie(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc agregacion escala.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcAgregacionEscala(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select agregacion escala.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectAgregacionEscala(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc movimiento tipo buque eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcMovimientoTipoBuqueEEE(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento tipo buque eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoTipoBuqueEEE(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc buque fondeado atracado.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcBuqueFondeadoAtracado(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select buque fondeado atracado.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectBuqueFondeadoAtracado(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Update srvc movimiento mercancia.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the int
     */
    int updateSrvcMovimientoMercancia(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento mercancia.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoMercancia(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);

    /**
     * Select movimiento mercancia eee.
     *
     * @param esagCriterioVO
     *            the esag criterio vo
     * @return the list
     */
    List<EstadisticaAgregadoVO> selectMovimientoMercanciaEEE(final @Nonnull EstadisticaAgregadoCriterioVO esagCriterioVO);
}
