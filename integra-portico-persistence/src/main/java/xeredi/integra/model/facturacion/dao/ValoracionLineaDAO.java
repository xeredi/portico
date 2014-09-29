package xeredi.integra.model.facturacion.dao;

import java.util.List;

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
    void insert(final ValoracionLineaVO vlrlVO);

    /**
     * Update.
     *
     * @param vlrlVO
     *            the vlrl vo
     * @return the int
     */
    int update(final ValoracionLineaVO vlrlVO);

    /**
     * Delete.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the int
     */
    int delete(final ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Select list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    List<ValoracionLineaVO> selectList(final ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Count.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the int
     */
    int count(final ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Select list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ValoracionLineaVO> selectList(final ValoracionLineaCriterioVO vlrlCriterioVO, final RowBounds bounds);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion linea vo
     */
    ValoracionLineaVO select(final Long id);

    /**
     * Exists dependencia.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    boolean existsDependencia(final Long vlrlId);

    /**
     * Checks if is regla valida.
     *
     * @param vlrl
     *            the vlrl
     * @return true, if is regla valida
     */
    boolean isRglaValida(final ValoracionLineaVO vlrl);
}
