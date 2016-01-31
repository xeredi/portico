package xeredi.argo.model.estadistica.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.estadistica.vo.InformeCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface InformeDAO.
 */
public interface InformeDAO {

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final InformeCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<Map<String, Object>> selectList(final InformeCriterioVO criterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<Map<String, Object>> selectList(final InformeCriterioVO criterio);
}
