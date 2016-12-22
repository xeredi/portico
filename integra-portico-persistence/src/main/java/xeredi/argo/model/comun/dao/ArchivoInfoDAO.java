package xeredi.argo.model.comun.dao;

import java.util.List;

import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArchivoInfoDAO.
 */
public interface ArchivoInfoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ArchivoInfoVO> selectList(final ArchivoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the archivo info VO
	 */
	ArchivoInfoVO selectObject(final ArchivoCriterioVO criterio);
}
