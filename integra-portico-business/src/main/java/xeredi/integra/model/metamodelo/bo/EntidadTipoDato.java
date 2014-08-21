package xeredi.integra.model.metamodelo.bo;

import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.util.exception.DuplicateInstanceException;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadTipoDato.
 */
public interface EntidadTipoDato {

    /**
     * Insert.
     * 
     * @param entdVO
     *            the entd vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final EntidadTipoDatoVO entdVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param entdVO
     *            the entd vo
     */
    void update(final EntidadTipoDatoVO entdVO);

    /**
     * Select.
     * 
     * @param entiId
     *            the enti id
     * @param tpdtId
     *            the tpdt id
     * @return the entidad tipo dato vo
     */
    EntidadTipoDatoVO select(final Long entiId, final Long tpdtId);
}
