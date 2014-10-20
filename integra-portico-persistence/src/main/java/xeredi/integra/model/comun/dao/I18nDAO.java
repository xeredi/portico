package xeredi.integra.model.comun.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.I18nCriterioVO;
import xeredi.integra.model.comun.vo.I18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface I18nDAO.
 */
public interface I18nDAO {
    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final I18nVO vo);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final I18nVO vo);

    /**
     * Delete list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteList(final I18nCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<I18nVO> selectList(final I18nCriterioVO criterioVO);

}