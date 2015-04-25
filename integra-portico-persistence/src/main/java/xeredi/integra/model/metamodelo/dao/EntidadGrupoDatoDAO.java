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
     * @param engdVO
     *            the engd vo
     */
    void insert(final EntidadGrupoDatoVO engdVO);

    /**
     * Update.
     *
     * @param engdVO
     *            the engd vo
     * @return the int
     */
    int update(final EntidadGrupoDatoVO engdVO);

    /**
     * Delete.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the int
     */
    int delete(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Delete list.
     *
     * @param entiId
     *            the enti id
     * @return the int
     */
    int deleteList(final Long entiId);

    /**
     * Select criterio.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the entidad grupo dato vo
     */
    EntidadGrupoDatoVO selectObject(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select list.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectAll();
}
