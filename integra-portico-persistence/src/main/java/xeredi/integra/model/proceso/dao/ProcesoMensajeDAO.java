package xeredi.integra.model.proceso.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;

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
     * @param criterio
     *            the criterio
     * @return the int
     */
    int deleteList(final ProcesoMensajeCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ProcesoMensajeVO> selectList(final ProcesoMensajeCriterioVO criterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final ProcesoMensajeCriterioVO criterio);
}
