package xeredi.integra.model.dao.proceso;

import java.util.List;

import xeredi.integra.model.vo.proceso.ProcesoItemVO;

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
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    List<ProcesoItemVO> selectList(final Long prbtId);

}
