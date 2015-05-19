package xeredi.integra.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

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
     * @param srtr
     *            the srtr
     * @return the int
     */
    int updateEstado(final ServicioTramiteVO srtr);

    /**
     * Select lupa list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ServicioVO> selectLupaList(final ServicioLupaCriterioVO srvcCriterioVO, final RowBounds bounds);
}
