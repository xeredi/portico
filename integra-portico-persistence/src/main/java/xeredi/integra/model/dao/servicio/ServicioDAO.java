package xeredi.integra.model.dao.servicio;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.servicio.ServicioCriterioVO;
import xeredi.integra.model.vo.servicio.ServicioLupaCriterioVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
     * Select count.
     * 
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the int
     */
    int selectCount(final ServicioCriterioVO srvcCriterioVO);

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
     * Select list.
     * 
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectList(final ServicioCriterioVO srvcCriterioVO);

    /**
     * Select object.
     * 
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the servicio vo
     */
    ServicioVO selectObject(final ServicioCriterioVO srvcCriterioVO);

    /**
     * Select.
     * 
     * @param srvcId
     *            the srvc id
     * @return the servicio vo
     */
    ServicioVO select(final Long srvcId);

    /**
     * Select lupa list.
     * 
     * @param srvcLupaCriterioVO
     *            the srvc lupa criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLupaList(final ServicioLupaCriterioVO srvcLupaCriterioVO);

}
