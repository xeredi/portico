package xeredi.integra.model.servicio.bo;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioBO.
 */
public interface ServicioBO {

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
    ServicioVO select(final @Nonnull Long srvcId, final @Nonnull String idioma) throws InstanceNotFoundException;

    /**
     * Select object.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ServicioVO selectObject(final @Nonnull ServicioCriterioVO srvcCriterioVO) throws InstanceNotFoundException;

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
    PaginatedList<ServicioVO> selectList(final @Nonnull ServicioCriterioVO srvcCriterioVO, final int offset,
            final int limit);

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectList(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Select lupa list.
     *
     * @param srvcLupaCriterioVO
     *            the srvc lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    List<ServicioVO> selectLupaList(final @Nonnull ServicioLupaCriterioVO srvcLupaCriterioVO, final int limit);

    /**
     * Insert.
     *
     * @param srvcVO
     *            the srvc vo
     * @param ssrvList
     *            the ssrv list
     * @param ssssList
     *            the ssss list
     * @param archId
     *            the arch id
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final @Nonnull ServicioVO srvcVO, final List<SubservicioVO> ssrvList,
            final List<SubservicioSubservicioVO> ssssList, final Long archId) throws DuplicateInstanceException;

    /**
     * Update.
     *
     * @param srvcVO
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    void update(final @Nonnull ServicioVO srvcVO) throws ModelException;

    /**
     * Duplicate.
     *
     * @param srvcVO
     *            the srvc vo
     * @throws ModelException
     *             the model exception
     */
    void duplicate(final @Nonnull ServicioVO srvcVO) throws ModelException;

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @throws ModelException
     *             the model exception
     */
    void delete(final @Nonnull Long srvcId) throws ModelException;

}
