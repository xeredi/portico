package xeredi.argo.model.comun.dao;

import java.util.List;

import xeredi.argo.model.comun.vo.MessageI18nCriterioVO;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageI18nDAO.
 */
public interface MessageI18nDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<MessageI18nVO> selectList(final MessageI18nCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final MessageI18nVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final MessageI18nCriterioVO vo);
}
