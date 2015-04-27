package xeredi.integra.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadDAO.
 */
public interface EntidadDAO {
    /**
     * Next sequence.
     *
     * @return the long
     */
    Long nextSequence();

    /**
     * Exists.
     *
     * @param entiVO
     *            the enti vo
     * @return true, if successful
     */
    boolean exists(final EntidadVO entiVO);

    /**
     * Insert.
     *
     * @param entiVO
     *            the enti vo
     */
    void insert(final EntidadVO entiVO);

    /**
     * Update.
     *
     * @param enti
     *            the enti
     * @return the int
     */
    int update(final EntidadVO enti);

    /**
     * Delete.
     *
     * @param enti
     *            the enti
     * @return the int
     */
    int delete(final EntidadVO enti);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the entidad vo
     */
    EntidadVO selectObject(final EntidadCriterioVO entiCriterio);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the entidad vo
     */
    EntidadVO select(final Long id);

    /**
     * Select list.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the list
     */
    List<EntidadVO> selectList(final EntidadCriterioVO entiCriterio);

    /**
     * Select map.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the map
     */
    @MapKey(value = "id")
    Map<Long, EntidadVO> selectMap(final EntidadCriterioVO entiCriterio);
}
