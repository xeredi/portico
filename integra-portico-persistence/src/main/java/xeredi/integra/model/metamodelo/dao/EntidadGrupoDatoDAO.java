package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadGrupoDatoDAO.
 */
public interface EntidadGrupoDatoDAO {

    /**
     * Insert.
     *
     * @param engd
     *            the engd
     */
    void insert(final EntidadGrupoDatoVO engd);

    /**
     * Update.
     *
     * @param engd
     *            the engd
     * @return the int
     */
    int update(final EntidadGrupoDatoVO engd);

    /**
     * Delete.
     *
     * @param engd
     *            the engd
     * @return the int
     */
    int delete(final EntidadGrupoDatoVO engd);

    /**
     * Delete list.
     *
     * @param engdCriterio
     *            the engd criterio
     * @return the int
     */
    int deleteList(final EntidadGrupoDatoCriterioVO engdCriterio);

    /**
     * Select criterio.
     *
     * @param engdCriterio
     *            the engd criterio
     * @return the entidad grupo dato vo
     */
    EntidadGrupoDatoVO selectObject(final EntidadGrupoDatoCriterioVO engdCriterio);

    /**
     * Select list.
     *
     * @param engdCriterio
     *            the engd criterio
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO engdCriterio);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectAll();
}
