package xeredi.argo.model.proceso.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

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
}
