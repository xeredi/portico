package xeredi.integra.model.comun.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.I18nCriterioVO;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface I18nDAO.
 */
public interface I18nDAO {

    /**
     * Exists.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull I18nVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final @Nonnull I18nVO vo);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final @Nonnull I18nVO vo);

    /**
     * Delete.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int delete(final @Nonnull I18nVO vo);

    /**
     * Delete list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteList(final @Nonnull I18nCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<I18nVO> selectList(final @Nonnull I18nCriterioVO criterioVO);

    /**
     * Select label value list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValueList(final @Nonnull I18nCriterioVO criterioVO);

}
