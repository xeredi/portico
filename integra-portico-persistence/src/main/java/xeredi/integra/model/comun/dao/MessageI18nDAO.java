package xeredi.integra.model.comun.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.MessageI18nCriterioVO;
import xeredi.integra.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageI18nDAO.
 */
public interface MessageI18nDAO {

    /**
     * Select language list.
     *
     * @return the list
     */
    List<String> selectLanguageList();

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<MessageI18nVO> selectList(final MessageI18nCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the message i18n vo
     */
    MessageI18nVO selectObject(final MessageI18nCriterioVO criterioVO);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final MessageI18nVO vo);
}
