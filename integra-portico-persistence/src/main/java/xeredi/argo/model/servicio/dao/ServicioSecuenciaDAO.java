package xeredi.argo.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioSecuenciaDAO.
 */
public interface ServicioSecuenciaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ServicioSecuenciaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ServicioSecuenciaVO> selectList(final ServicioSecuenciaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the servicio secuencia VO
	 */
	ServicioSecuenciaVO selectObject(final ServicioSecuenciaCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final ServicioSecuenciaVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ServicioSecuenciaVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final ServicioSecuenciaVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final ServicioSecuenciaVO vo);

	/**
	 * Incrementar secuencia.
	 *
	 * @param srvc
	 *            the srvc
	 * @return the int
	 */
	int incrementarSecuencia(final ServicioVO srvc);

	/**
	 * Obtener secuencia.
	 *
	 * @param srvc
	 *            the srvc
	 * @return the integer
	 */
	Integer obtenerSecuencia(final ServicioVO srvc);
}
