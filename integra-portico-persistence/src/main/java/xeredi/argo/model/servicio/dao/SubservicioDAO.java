package xeredi.argo.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioDAO.
 */
public interface SubservicioDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final SubservicioCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<SubservicioVO> selectList(final SubservicioCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<SubservicioVO> selectList(final SubservicioCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the subservicio VO
	 */
	SubservicioVO selectObject(final SubservicioCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final SubservicioVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final SubservicioVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final SubservicioVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final SubservicioCriterioVO vo);

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
