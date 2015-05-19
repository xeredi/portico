package xeredi.integra.model.maestro.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDatoDAO.
 */
public interface SubparametroDatoDAO extends CrudDAO<ItemDatoVO, SubparametroCriterioVO> {
    /**
     * Delete version. FIXME Cambiar por deleteList
     *
     * @param sprm
     *            the sprm
     * @return the int
     */
    int deleteVersion(final SubparametroVO sprm);
}
