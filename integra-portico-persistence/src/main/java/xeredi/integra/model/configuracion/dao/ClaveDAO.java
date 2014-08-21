package xeredi.integra.model.configuracion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.configuracion.vo.ClaveCriterioVO;
import xeredi.integra.model.configuracion.vo.ClaveVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClaveDAO.
 */
public interface ClaveDAO {

    /**
     * Select all map.
     *
     * @return the map
     */
    @MapKey("clave")
    Map<String, ClaveVO> selectAllMap();

    /**
     * Select list.
     *
     * @param cnclCriterioVO
     *            the cncl criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ClaveVO> selectList(final ClaveCriterioVO cnclCriterioVO, final RowBounds bounds);

    /**
     * Select count.
     *
     * @param cnclCriterioVO
     *            the cncl criterio vo
     * @return the int
     */
    int selectCount(final ClaveCriterioVO cnclCriterioVO);

    /**
     * Exists.
     *
     * @param cnclVO
     *            the cncl vo
     * @return true, if successful
     */
    boolean exists(final ClaveVO cnclVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the clave vo
     */
    ClaveVO select(final Long id);

    /**
     * Insert.
     *
     * @param cnclVO
     *            the cncl vo
     */
    void insert(final ClaveVO cnclVO);

    /**
     * Update.
     *
     * @param cnclVO
     *            the cncl vo
     * @return the int
     */
    int update(final ClaveVO cnclVO);
}
