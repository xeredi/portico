package xeredi.integra.model.metamodelo.bo;

import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadEntidad.
 */
public interface EntidadEntidad {

    /**
     * Insert.
     *
     * @param enenVO
     *            the enen vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final EntidadEntidadVO enenVO) throws DuplicateInstanceException;

    /**
     * Update.
     *
     * @param enenVO
     *            the enen vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final EntidadEntidadVO enenVO) throws InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param enenVO
     *            the enen vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final EntidadEntidadVO enenVO) throws InstanceNotFoundException;
}
