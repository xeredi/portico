package xeredi.integra.model.dao.maestro;

import java.util.List;

import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.comun.ItemDatoVO;

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
