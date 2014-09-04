package xeredi.integra.model.metamodelo.bo;

import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodigoReferencia.
 */
public interface CodigoReferencia {

    /**
     * Insert.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final CodigoReferenciaVO cdrfVO) throws DuplicateInstanceException;

    /**
     * Update.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException;

    /**
     * Select object.
     *
     * @param cdrfCriterioVO
     *            the cdrf criterio vo
     * @return the codigo referencia vo
     */
    CodigoReferenciaVO selectObject(final CodigoReferenciaCriterioVO cdrfCriterioVO);
}
