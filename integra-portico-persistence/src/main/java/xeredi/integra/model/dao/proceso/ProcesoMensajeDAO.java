package xeredi.integra.model.dao.proceso;

import java.util.List;

import xeredi.integra.model.vo.proceso.ProcesoMensajeVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoMensajeDAO.
 */
public interface ProcesoMensajeDAO {

    /**
     * Insert.
     * 
     * @param prmnVO
     *            the prmn vo
     */
    void insert(final ProcesoMensajeVO prmnVO);

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
    List<ProcesoMensajeVO> selectList(final Long prbtId);

}
