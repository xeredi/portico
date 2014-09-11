package xeredi.integra.model.facturacion.bo;

import java.util.List;

import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatible.
 */
public interface ReglaIncompatible {

    /**
     * Insert.
     *
     * @param rgin
     *            the rgin
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final ReglaIncompatibleVO rgin) throws OverlapException;

    /**
     * Update.
     *
     * @param rgin
     *            the rgin
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    void update(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException;

    /**
     * Delete.
     *
     * @param rgin
     *            the rgin
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException;

    /**
     * Select.
     *
     * @param rginCriterio
     *            the rgin criterio
     * @return the regla incompatible vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ReglaIncompatibleVO select(final ReglaIncompatibleCriterioVO rginCriterio) throws InstanceNotFoundException;

    /**
     * Select list.
     *
     * @param rginCriterioVO
     *            the rgin criterio vo
     * @return the list
     */
    List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO rginCriterioVO);
}
