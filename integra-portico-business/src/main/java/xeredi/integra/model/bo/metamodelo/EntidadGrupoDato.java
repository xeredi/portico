package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadGrupoDato.
 */
public interface EntidadGrupoDato {

    /**
     * Insert.
     * 
     * @param engdVO
     *            the engd vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final EntidadGrupoDatoVO engdVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param engdVO
     *            the engd vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final EntidadGrupoDatoVO engdVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param entiId
     *            the enti id
     * @param numero
     *            the numero
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long entiId, final Integer numero) throws InstanceNotFoundException;

    /**
     * Select.
     * 
     * @param entiId
     *            the enti id
     * @param numero
     *            the numero
     * @return the entidad grupo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    EntidadGrupoDatoVO select(final Long entiId, final Integer numero) throws InstanceNotFoundException;

    /**
     * Select list.
     * 
     * @param entiId
     *            the enti id
     * @return the list
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    List<EntidadGrupoDatoVO> selectList(final Long entiId) throws InstanceNotFoundException;

    /**
     * Select label values.
     * 
     * @param entiId
     *            the enti id
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final Long entiId);
}
