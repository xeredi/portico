package xeredi.argo.model.servicio.dao.amarredep;

import java.util.List;

import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AmarreDeportivoServicioDAO.
 */
public interface AmarreDeportivoServicioDAO {

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ServicioMaestroVO> selectGenerateList(final ServicioCriterioVO criterio);
}
