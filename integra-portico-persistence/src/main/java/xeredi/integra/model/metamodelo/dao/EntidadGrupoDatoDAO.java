package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull EntidadGrupoDatoVO engdVO);

    /**
     * Update.
     *
     * @param engdVO
     *            the engd vo
     * @return the int
     */
    int update(final @Nonnull EntidadGrupoDatoVO engdVO);

    /**
     * Delete.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the int
     */
    int delete(final @Nonnull EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Delete list.
     *
     * @param entiId
     *            the enti id
     * @return the int
     */
    int deleteList(final @Nonnull Long entiId);

    /**
     * Select criterio.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the entidad grupo dato vo
     */
    EntidadGrupoDatoVO selectObject(final @Nonnull EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select list.
     *
     * @param engdCriterioVO
     *            the engd criterio vo
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectList(final @Nonnull EntidadGrupoDatoCriterioVO engdCriterioVO);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectAll();
}
