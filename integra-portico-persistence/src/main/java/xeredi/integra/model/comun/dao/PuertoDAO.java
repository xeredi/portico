package xeredi.integra.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PuertoDAO.
 */
public interface PuertoDAO {
    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the puerto vo
     */
    PuertoVO selectObject(final PuertoCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<PuertoVO> selectList(final PuertoCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<PuertoVO> selectList(final PuertoCriterioVO criterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final PuertoCriterioVO criterio);
}
