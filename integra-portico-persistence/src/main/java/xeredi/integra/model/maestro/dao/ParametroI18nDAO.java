package xeredi.integra.model.maestro.dao;

import java.util.List;

import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroI18nDAO.
 */
public interface ParametroI18nDAO {

    /**
     * Insert.
     *
     * @param p18nVO
     *            the p18n vo
     */
    void insert(final ParametroI18nVO p18nVO);

    /**
     * Update.
     *
     * @param p18n
     *            the p18n
     * @return the int
     */
    int update(final ParametroI18nVO p18n);

    /**
     * Delete.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int deleteVersion(final ParametroVO prmt);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroI18nVO> selectList(final ParametroCriterioVO prmtCriterioVO);
}
