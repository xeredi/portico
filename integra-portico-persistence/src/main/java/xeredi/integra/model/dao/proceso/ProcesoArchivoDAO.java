package xeredi.integra.model.dao.proceso;

import java.util.List;

import xeredi.integra.model.vo.proceso.ProcesoArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoArchivoDAO.
 */
public interface ProcesoArchivoDAO {

    /**
     * Insert.
     * 
     * @param prarVO
     *            the prar vo
     */
    void insert(final ProcesoArchivoVO prarVO);

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
    List<ProcesoArchivoVO> selectList(final Long prbtId);
}
