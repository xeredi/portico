package xeredi.argo.model.metamodelo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadDAO.
 */
public interface EntidadDAO extends CrudDAO<EntidadVO, EntidadCriterioVO> {
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
