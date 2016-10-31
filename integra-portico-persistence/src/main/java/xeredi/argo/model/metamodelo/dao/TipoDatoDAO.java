package xeredi.argo.model.metamodelo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoDatoDAO.
 */
public interface TipoDatoDAO extends CrudDAO<TipoDatoVO, TipoDatoCriterioVO> {
    /**
     * Select map.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the map
     */
    @MapKey("id")
    Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterio);
}
