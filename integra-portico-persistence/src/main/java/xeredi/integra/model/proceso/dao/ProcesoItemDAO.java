package xeredi.integra.model.proceso.dao;

import java.util.List;

import xeredi.integra.model.proceso.vo.ProcesoItemCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoItemDAO.
 */
public interface ProcesoItemDAO {

    /**
     * Insert.
     *
     * @param pritVO
     *            the prit vo
     */
    void insert(final ProcesoItemVO pritVO);

    /**
     * Delete.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int delete(final Long prbtId);

    /**
     * Select list.
     *
     * @param pritCriterio
     *            the prit criterio
     * @return the list
     */
    List<ProcesoItemVO> selectList(final ProcesoItemCriterioVO pritCriterio);

}
