package xeredi.integra.model.maestro.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDatoDAO.
 */
public interface ParametroDatoDAO {

	/**
	 * Insert.
	 *
	 * @param prdtVO
	 *            the prdt vo
	 */
	void insert(final ItemDatoVO prdtVO);

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the list
	 */
	List<ItemDatoVO> selectList(final ParametroCriterioVO prmtCriterioVO);
}
