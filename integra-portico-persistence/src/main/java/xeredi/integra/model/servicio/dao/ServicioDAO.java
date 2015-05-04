package xeredi.integra.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioDAO.
 */
public interface ServicioDAO {

    /**
     * Exists.
     *
     * @param srvcVO
     *            the srvc vo
     * @return true, if successful
     */
    boolean exists(final ServicioVO srvcVO);

    /**
     * Insert.
     *
     * @param srvcVO
     *            the srvc vo
     */
    void insert(final ServicioVO srvcVO);

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int delete(final Long srvcId);

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
     * Select count.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the int
     */
    int count(final ServicioCriterioVO srvcCriterioVO);

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO);

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO, final RowBounds bounds);

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

    /**
     * Select object.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the servicio vo
     */
    ServicioVO selectObject(final ServicioCriterioVO srvcCriterioVO);

}
