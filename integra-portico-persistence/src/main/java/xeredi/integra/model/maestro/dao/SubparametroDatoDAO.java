package xeredi.integra.model.maestro.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;

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
