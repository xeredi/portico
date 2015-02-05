package xeredi.integra.model.maestro.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull ItemDatoVO prdt);

    /**
     * Update.
     *
     * @param prdt
     *            the prdt
     * @return the int
     */
    int update(final @Nonnull ItemDatoVO prdt);

    /**
     * Delete version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int deleteVersion(final @Nonnull ParametroVO prmt);

    /**
     * Select list.
     *
     * @param prmtCriterio
     *            the prmt criterio
     * @return the list
     */
    List<ItemDatoVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterio);
}
