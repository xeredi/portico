package xeredi.integra.model.comun.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.MessageI18nCriterioVO;
import xeredi.integra.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageI18nDAO.
 */
public interface MessageI18nDAO {

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<MessageI18nVO> selectList(final @Nonnull MessageI18nCriterioVO criterio);

    /**
     * Delete list.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int deleteList(final @Nonnull MessageI18nCriterioVO criterio);

    /**
     * Insert.
     *
     * @param m18n
     *            the m18n
     */
    void insert(final @Nonnull MessageI18nVO m18n);
}
