package xeredi.integra.model.servicio.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemTramiteDatoVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioTramiteDatoDAO.
 */
public interface ServicioTramiteDatoDAO {

    /**
     * Insert.
     *
     * @param itdt
     *            the itdt
     */
    void insert(final ItemTramiteDatoVO itdt);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ItemTramiteDatoVO> selectList(final ServicioTramiteCriterioVO criterio);
}
