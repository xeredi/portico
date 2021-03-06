package xeredi.argo.model.servicio.dao.buquepesca;

import java.util.List;

import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BuquePescaServicioDAO.
 */
public interface BuquePescaServicioDAO {

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ServicioMaestroVO> selectGenerateList(final ServicioCriterioVO criterio);
}
