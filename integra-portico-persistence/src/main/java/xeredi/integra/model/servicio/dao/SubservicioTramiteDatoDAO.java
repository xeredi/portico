package xeredi.integra.model.servicio.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemTramiteDatoVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioTramiteDatoDAO.
 */
public interface SubservicioTramiteDatoDAO {

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
    List<ItemTramiteDatoVO> selectList(final SubservicioTramiteCriterioVO criterio);
}
