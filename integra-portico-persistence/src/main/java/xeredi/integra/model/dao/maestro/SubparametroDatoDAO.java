package xeredi.integra.model.dao.maestro;

import java.util.List;

import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.SubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDatoDAO.
 */
public interface SubparametroDatoDAO {

    /**
     * Select list.
     * 
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<ItemDatoVO> selectList(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Insert.
     * 
     * @param itdtVO
     *            the itdt vo
     */
    void insert(final ItemDatoVO itdtVO);
}
