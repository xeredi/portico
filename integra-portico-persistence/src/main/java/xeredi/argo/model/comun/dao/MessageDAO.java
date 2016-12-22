package xeredi.argo.model.comun.dao;

import java.util.List;

import xeredi.argo.model.comun.vo.MessageCriterioVO;
import xeredi.argo.model.comun.vo.MessageVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageDAO.
 */
public interface MessageDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<MessageVO> selectList(final MessageCriterioVO criterio);
}
