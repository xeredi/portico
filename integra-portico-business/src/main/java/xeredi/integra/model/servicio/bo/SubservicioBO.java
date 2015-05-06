package xeredi.integra.model.servicio.bo;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;
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
     * @param ssrvCriterio
     *            the ssrv criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterio, final int offset, final int limit);

    /**
     * Select list.
     *
     * @param ssrvCriterio
     *            the ssrv criterio
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterio);

    /**
     * Select label value object.
     *
     * @param ssrvCriterio
     *            the ssrv criterio
     * @return the label value vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    LabelValueVO selectLabelValueObject(final SubservicioCriterioVO ssrvCriterio) throws InstanceNotFoundException;

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
     * @param ssrvLupaCriterio
     *            the ssrv lupa criterio
     * @param limit
     *            the limit
     * @return the list
     */
    List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvLupaCriterio, final int limit);

    /**
     * Insert.
     *
     * @param ssrv
     *            the ssrv
     * @param tpssDetail
     *            the tpss detail
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final SubservicioVO ssrv, final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds)
            throws DuplicateInstanceException;

    /**
     * Duplicate.
     *
     * @param ssrv
     *            the ssrv
     */
    void duplicate(final SubservicioVO ssrv);

    /**
     * Update.
     *
     * @param ssrv
     *            the ssrv
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final SubservicioVO ssrv) throws InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param ssrv
     *            the ssrv
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final SubservicioVO ssrv) throws InstanceNotFoundException;

    /**
     * Statechange.
     *
     * @param sstr
     *            the sstr
     * @throws ModelException
     *             the model exception
     */
    void statechange(final SubservicioTramiteVO sstr) throws ModelException;
}
