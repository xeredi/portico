package xeredi.integra.model.dao.maestro;

import java.util.List;

import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroI18nDAO.
 */
public interface ParametroI18nDAO {

	/**
	 * Insert.
	 *
	 * @param p18nVO
	 *            the p18n vo
	 */
	void insert(final ParametroI18nVO p18nVO);

	/**
	 * Update.
	 *
	 * @param p18nVO
	 *            the p18n vo
	 */
	void update(final ParametroI18nVO p18nVO);

	/**
	 * Update delete.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 */
	void updateDelete(final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the list
	 */
	List<ParametroI18nVO> selectList(final ParametroCriterioVO prmtCriterioVO);
}
