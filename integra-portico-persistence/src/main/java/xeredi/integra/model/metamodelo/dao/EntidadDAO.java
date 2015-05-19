package xeredi.integra.model.metamodelo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadDAO.
 */
public interface EntidadDAO extends CrudDAO<EntidadVO, EntidadCriterioVO> {
    /**
     * Next sequence.
     *
     * @return the long
     */
    Long nextSequence();

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the entidad vo
     */
    EntidadVO select(final Long id);

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
