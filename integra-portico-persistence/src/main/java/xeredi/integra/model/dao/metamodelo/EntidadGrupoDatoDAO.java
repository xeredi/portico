package xeredi.integra.model.dao.metamodelo;

import java.util.List;

import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
     * Exists.
     * 
     * @param engdVO
     *            the engd vo
     * @return true, if successful
     */
    boolean exists(final EntidadGrupoDatoVO engdVO);

    /**
     * Select criterio.
     * 
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the entidad grupo dato vo
     */
    EntidadGrupoDatoVO selectCriterio(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select list.
     * 
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select label values.
     * 
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select all.
     * 
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectAll();
}
