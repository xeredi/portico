package xeredi.integra.model.servicio.bo;

import java.util.List;

import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Servicio.
 */
public interface Servicio {

    /**
     * Select.
     *
     * @param srvcId
     *            the srvc id
     * @param idioma
     *            the idioma
     * @return the servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ServicioVO select(final Long srvcId, final String idioma) throws InstanceNotFoundException;

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO, final int offset, final int limit);

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO);

    /**
     * Select lupa list.
     *
     * @param srvcLupaCriterioVO
     *            the srvc lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    List<LabelValueVO> selectLupaList(final ServicioLupaCriterioVO srvcLupaCriterioVO, final int limit);

    /**
     * Insert.
     *
     * @param srvcVO
     *            the srvc vo
     * @param ssrvList
     *            the ssrv list
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final ServicioVO srvcVO, final List<SubservicioVO> ssrvList) throws DuplicateInstanceException;

    /**
     * Update.
     *
     * @param srvcVO
     *            the srvc vo
     */
    void update(final ServicioVO srvcVO);

    /**
     * Duplicate.
     *
     * @param srvcVO
     *            the srvc vo
     */
    void duplicate(final ServicioVO srvcVO);

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long srvcId) throws InstanceNotFoundException;
}
