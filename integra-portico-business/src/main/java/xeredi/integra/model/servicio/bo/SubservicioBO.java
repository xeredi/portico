package xeredi.integra.model.servicio.bo;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioBO.
 */
public interface SubservicioBO {

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO, final int offset,
            final int limit);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select label value object.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the label value vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    LabelValueVO selectLabelValueObject(final SubservicioCriterioVO ssrvCriterioVO) throws InstanceNotFoundException;

    /**
     * Select.
     *
     * @param ssrvId
     *            the ssrv id
     * @param idioma
     *            the idioma
     * @return the subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    SubservicioVO select(final Long ssrvId, final String idioma) throws InstanceNotFoundException;

    /**
     * Select lupa list.
     *
     * @param ssrvLupaCriterioVO
     *            the ssrv lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvLupaCriterioVO, final int limit);

    /**
     * Insert.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @param tpssDetail
     *            the tpss detail
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final SubservicioVO ssrvVO, final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds)
            throws DuplicateInstanceException;

    /**
     * Duplicate.
     *
     * @param ssrvVO
     *            the ssrv vo
     */
    void duplicate(final SubservicioVO ssrvVO);

    /**
     * Update.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final SubservicioVO ssrvVO) throws InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param ssrv
     *            the ssrv
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final SubservicioVO ssrv) throws InstanceNotFoundException;

}
