package xeredi.integra.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SuperpuertoDAO.
 */
public interface SuperpuertoDAO {

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the superpuerto vo
     */
    SuperpuertoVO selectObject(final SuperpuertoCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<SuperpuertoVO> selectList(final SuperpuertoCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SuperpuertoVO> selectList(final SuperpuertoCriterioVO criterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final SuperpuertoCriterioVO criterio);
}
