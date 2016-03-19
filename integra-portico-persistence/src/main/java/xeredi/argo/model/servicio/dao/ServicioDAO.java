package xeredi.argo.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioDAO.
 */
public interface ServicioDAO extends CrudDAO<ServicioVO, ServicioCriterioVO> {
    /**
     * Update pepr desasociar.
     *
     * @param peprId
     *            the pepr id
     * @return the int
     */
    int updatePeprDesasociar(final Long peprId);

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
     * @param criterio
     *            the srvc criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ServicioVO> selectTypeaheadList(final ServicioTypeaheadCriterioVO criterio, final RowBounds bounds);
}
