package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadGrupoDatoDAO.
 */
public interface EntidadGrupoDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the entidad grupo dato VO
	 */
	EntidadGrupoDatoVO selectObject(final EntidadGrupoDatoCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final EntidadGrupoDatoVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final EntidadGrupoDatoVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final EntidadGrupoDatoVO vo);
}
