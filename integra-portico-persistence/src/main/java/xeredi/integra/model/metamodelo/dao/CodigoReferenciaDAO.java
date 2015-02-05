package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodigoReferenciaDAO.
 */
public interface CodigoReferenciaDAO {

    /**
     * Select criterio.
     *
     * @param cdrfCriterioVO
     *            the cdrf criterio vo
     * @return the list
     */
    List<CodigoReferenciaVO> selectList(final @Nonnull CodigoReferenciaCriterioVO cdrfCriterioVO);

    /**
     * Select object.
     *
     * @param cdrfCriterioVO
     *            the cdrf criterio vo
     * @return the codigo referencia vo
     */
    CodigoReferenciaVO selectObject(final @Nonnull CodigoReferenciaCriterioVO cdrfCriterioVO);

    /**
     * Exists.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull CodigoReferenciaVO cdrfVO);

    /**
     * Insert.
     *
     * @param cdrfVO
     *            the cdrf vo
     */
    void insert(final @Nonnull CodigoReferenciaVO cdrfVO);

    /**
     * Update.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @return the int
     */
    int update(final @Nonnull CodigoReferenciaVO cdrfVO);

    /**
     * Delete.
     *
     * @param cdrfId
     *            the cdrf id
     * @return the int
     */
    int delete(final @Nonnull Long cdrfId);

    /**
     * Delete list.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the int
     */
    int deleteList(final @Nonnull Long tpdtId);
}
