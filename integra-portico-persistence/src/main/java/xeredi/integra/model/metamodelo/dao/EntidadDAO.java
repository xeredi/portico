package xeredi.integra.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;

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
     * @param entiVO
     *            the enti vo
     * @return the int
     */
    int update(final EntidadVO entiVO);

    /**
     * Delete.
     *
     * @param entiId
     *            the enti id
     * @return the int
     */
    int delete(final Long entiId);

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
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the list
     */
    List<EntidadVO> selectList(final EntidadCriterioVO entiCriterioVO);

    /**
     * Select map.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the map
     */
    @MapKey(value = "id")
    Map<Long, EntidadVO> selectMap(final EntidadCriterioVO entiCriterioVO);

    /**
     * Select tipo entidad.
     *
     * @param id
     *            the id
     * @return the tipo entidad
     */
    TipoEntidad selectTipoEntidad(final Long id);
}
