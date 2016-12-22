package xeredi.argo.model.comun.dao;

import java.util.List;

import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface I18nDAO.
 */
public interface I18nDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<I18nVO> selectList(final I18nCriterioVO criterio);

	/**
	 * Select label value list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValueList(final I18nCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final I18nVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final I18nCriterioVO vo);
}
