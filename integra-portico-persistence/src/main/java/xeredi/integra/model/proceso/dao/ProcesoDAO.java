package xeredi.integra.model.proceso.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoDAO.
 */
public interface ProcesoDAO extends CrudDAO<ProcesoVO, ProcesoCriterioVO> {
    /**
     * Update iniciar.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int updateIniciar(final Long prbtId);

    /**
     * Update finalizar.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int updateFinalizar(final Long prbtId);

    /**
     * Select.
     *
     * @param prbtId
     *            the prbt id
     * @return the proceso vo
     */
    ProcesoVO select(final Long prbtId);
}
