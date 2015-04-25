package xeredi.integra.model.maestro.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDatoDAO.
 */
public interface ParametroDatoDAO {

    /**
     * Insert.
     *
     * @param prdt
     *            the prdt
     */
    void insert(final ItemDatoVO prdt);

    /**
     * Update.
     *
     * @param prdt
     *            the prdt
     * @return the int
     */
    int update(final ItemDatoVO prdt);

    /**
     * Delete version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int deleteVersion(final ParametroVO prmt);

    /**
     * Select list.
     *
     * @param prmtCriterio
     *            the prmt criterio
     * @return the list
     */
    List<ItemDatoVO> selectList(final ParametroCriterioVO prmtCriterio);
}
