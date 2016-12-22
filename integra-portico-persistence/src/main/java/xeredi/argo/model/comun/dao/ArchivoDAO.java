package xeredi.argo.model.comun.dao;

import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArchivoDAO.
 */
public interface ArchivoDAO {

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the archivo VO
	 */
	ArchivoVO selectObject(final ArchivoCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ArchivoVO vo);
}
