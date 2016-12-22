package xeredi.argo.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioDAO.
 */
public interface ServicioDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ServicioCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ServicioVO> selectList(final ServicioCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ServicioVO> selectList(final ServicioCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the servicio VO
	 */
	ServicioVO selectObject(final ServicioCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final ServicioVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ServicioVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final ServicioVO vo);

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
