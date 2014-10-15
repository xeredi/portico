package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.CodigoReferenciaI18nCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodigoReferenciaI18nDAO.
 */
public interface CodigoReferenciaI18nDAO {

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<CodigoReferenciaI18nVO> selectList(final CodigoReferenciaI18nCriterioVO criterioVO);

    /**
     * Exists.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean exists(final CodigoReferenciaI18nVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final CodigoReferenciaI18nVO vo);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final CodigoReferenciaI18nVO vo);

    /**
     * Delete list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteList(final CodigoReferenciaI18nCriterioVO criterioVO);
}
