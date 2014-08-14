package xeredi.integra.model.dao.facturacion;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDAO.
 */
public interface ValoracionDAO {

    /**
     * Insert.
     *
     * @param vlrcVO
     *            the vlrc vo
     */
    void insert(final ValoracionVO vlrcVO);

    /**
     * Delete.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the int
     */
    int delete(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion vo
     */
    ValoracionVO select(final Long id);

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionVO> selectList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Count.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the int
     */
    int count(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ValoracionVO> selectList(final ValoracionCriterioVO vlrcCriterioVO, final RowBounds bounds);
}
