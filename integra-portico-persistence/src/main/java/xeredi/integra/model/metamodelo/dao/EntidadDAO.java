package xeredi.integra.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

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
    boolean exists(final @Nonnull EntidadVO entiVO);

    /**
     * Insert.
     *
     * @param entiVO
     *            the enti vo
     */
    void insert(final @Nonnull EntidadVO entiVO);

    /**
     * Update.
     *
     * @param entiVO
     *            the enti vo
     * @return the int
     */
    int update(final @Nonnull EntidadVO entiVO);

    /**
     * Delete.
     *
     * @param entiId
     *            the enti id
     * @return the int
     */
    int delete(final @Nonnull Long entiId);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the entidad vo
     */
    EntidadVO selectObject(final @Nonnull EntidadCriterioVO entiCriterioVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the entidad vo
     */
    EntidadVO select(final @Nonnull Long id);

    /**
     * Select list.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    List<EntidadVO> selectList(final @Nonnull EntidadCriterioVO entiCriterioVO);

    /**
     * Select map.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the map
     */
    @MapKey(value = "id")
    Map<Long, EntidadVO> selectMap(final @Nonnull EntidadCriterioVO entiCriterioVO);
}
