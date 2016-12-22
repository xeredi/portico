package xeredi.argo.model.estadistica.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PeriodoProcesoDAO.
 */
public interface PeriodoProcesoDAO {

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final PeriodoProcesoVO vo);

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final PeriodoProcesoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the periodo proceso VO
	 */
	PeriodoProcesoVO selectObject(final PeriodoProcesoCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final PeriodoProcesoVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final PeriodoProcesoVO vo);
}
