package xeredi.argo.model.maestro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDAO.
 */
public interface ParametroDAO extends CrudDAO<ParametroVO, ParametroCriterioVO>, CrudVersionableDAO<ParametroVO> {

    /**
     * Select id.
     *
     * @param prmt
     *            the prmt
     * @return the long
     */
    Long selectId(final ParametroVO prmt);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("parametro")
    Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("id")
    Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select typeahead sprm list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectSprmList(final SubparametroCriterioVO criterio, final RowBounds bounds);
}
