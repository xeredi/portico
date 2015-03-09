package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionLineaDAO.
 */
public interface ValoracionLineaDAO {

    /**
     * Insert.
     *
     * @param vlrlVO
     *            the vlrl vo
     */
    void insert(final @Nonnull ValoracionLineaVO vlrlVO);

    /**
     * Update.
     *
     * @param vlrlVO
     *            the vlrl vo
     * @return the int
     */
    int update(final @Nonnull ValoracionLineaVO vlrlVO);

    /**
     * Delete.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the int
     */
    int delete(final @Nonnull ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Select list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    List<ValoracionLineaVO> selectList(final @Nonnull ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Count.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the int
     */
    int count(final @Nonnull ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Select list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ValoracionLineaVO> selectPaginatedList(final @Nonnull ValoracionLineaCriterioVO vlrlCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select.
     *
     * @param vlrlCriterio
     *            the vlrl criterio
     * @return the valoracion linea vo
     */
    ValoracionLineaVO selectObject(final @Nonnull ValoracionLineaCriterioVO vlrlCriterio);

    /**
     * Exists dependencia.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    boolean existsDependencia(final @Nonnull Long vlrlId);

    /**
     * Checks if is regla valida.
     *
     * @param vlrl
     *            the vlrl
     * @return true, if is regla valida
     */
    boolean isRglaValida(final @Nonnull ValoracionLineaVO vlrl);
}
