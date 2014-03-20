package xeredi.integra.model.dao.proceso;

import java.util.List;

import xeredi.integra.model.vo.proceso.ProcesoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoParametroDAO.
 */
public interface ProcesoParametroDAO {

    /**
     * Insert.
     * 
     * @param prpmVO
     *            the prpm vo
     */
    void insert(final ProcesoParametroVO prpmVO);

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
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    List<ProcesoParametroVO> selectList(final Long prbtId);

}
