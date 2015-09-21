package xeredi.argo.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioDAO.
 */
public interface SubservicioDAO extends CrudDAO<SubservicioVO, SubservicioCriterioVO> {

    /**
     * Update estado.
     *
     * @param ittr
     *            the ittr
     * @return the int
     */
    int updateEstado(final ItemTramiteVO ittr);

    /**
     * Select lupa list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvCriterioVO, final RowBounds bounds);
}
