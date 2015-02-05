package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioLupaCriterioVO;
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
    boolean exists(final @Nonnull ServicioVO srvcVO);

    /**
     * Insert.
     *
     * @param srvcVO
     *            the srvc vo
     */
    void insert(final @Nonnull ServicioVO srvcVO);

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int delete(final @Nonnull Long srvcId);

    /**
     * Update pepr desasociar.
     *
     * @param peprId
     *            the pepr id
     * @return the int
     */
    int updatePeprDesasociar(final @Nonnull Long peprId);

    /**
     * Select count.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the int
     */
    int selectCount(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectList(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Select paginated list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ServicioVO> selectPaginatedList(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Select object.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the servicio vo
     */
    ServicioVO selectObject(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Select.
     *
     * @param srvcId
     *            the srvc id
     * @return the servicio vo
     */
    ServicioVO select(final @Nonnull Long srvcId);

    /**
     * Select lupa list.
     *
     * @param srvcLupaCriterioVO
     *            the srvc lupa criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ServicioVO> selectLupaList(final @Nonnull ServicioLupaCriterioVO srvcLupaCriterioVO,
            @Nonnull final RowBounds bounds);

}
