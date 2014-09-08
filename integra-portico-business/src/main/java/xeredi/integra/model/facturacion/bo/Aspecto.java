package xeredi.integra.model.facturacion.bo;

import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Aspecto.
 */
public interface Aspecto {

    /**
     * Busqueda de Aspectos que cumplan un criterio de busqueda.
     *
     * @param aspcCriterioVO
     *            Criterio de busqueda de aspectos.
     * @param offset
     *            Posicion desde la que se empieza a devolver resultados.
     * @param limit
     *            Numero maximo de resultados.
     * @return {@link PaginatedList} de {@link AspectoVO} que cumplan el criterio de busqueda.
     */
    PaginatedList<AspectoVO> selectList(final AspectoCriterioVO aspcCriterioVO, final int offset, final int limit);

    /**
     * Busqueda de un aspecto que cumpla un criterio de busqueda.
     *
     * @param aspcCriterioVO
     *            Criterio de busqueda de aspectos.
     * @return Datos del asperto que cumpla el criterio de busqueda.
     */
    AspectoVO select(final AspectoCriterioVO aspcCriterioVO);

    /**
     * Insert.
     *
     * @param aspc
     *            the aspc
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final AspectoVO aspc) throws DuplicateInstanceException;

    /**
     * Update.
     *
     * @param aspc
     *            the aspc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final AspectoVO aspc) throws InstanceNotFoundException;

    /**
     * Duplicate.
     *
     * @param aspc
     *            the aspc
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void duplicate(final AspectoVO aspc) throws DuplicateInstanceException;

}
