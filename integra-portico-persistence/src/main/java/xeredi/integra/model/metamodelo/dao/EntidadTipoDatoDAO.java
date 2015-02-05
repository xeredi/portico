package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroTipoDatoDAO.
 */
public interface EntidadTipoDatoDAO {

    /**
     * Exists.
     *
     * @param entdVO
     *            the entd vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull EntidadTipoDatoVO entdVO);

    /**
     * Insert.
     *
     * @param entdVO
     *            the entd vo
     */
    void insert(final @Nonnull EntidadTipoDatoVO entdVO);

    /**
     * Update.
     *
     * @param entdVO
     *            the entd vo
     * @return the int
     */
    int update(final @Nonnull EntidadTipoDatoVO entdVO);

    /**
     * Delete.
     *
     * @param entdVO
     *            the entd vo
     * @return the int
     */
    int delete(final @Nonnull EntidadTipoDatoVO entdVO);

    /**
     * Delete list.
     *
     * @param entdCriterioVO
     *            the entd criterio vo
     * @return the int
     */
    int deleteList(final @Nonnull EntidadTipoDatoCriterioVO entdCriterioVO);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadTipoDatoVO> selectAll();

    /**
     * Select criterio.
     *
     * @param entdCriterioVO
     *            the entd criterio vo
     * @return the list
     */
    List<EntidadTipoDatoVO> selectList(final @Nonnull EntidadTipoDatoCriterioVO entdCriterioVO);

    /**
     * Select object.
     *
     * @param entdCriterioVO
     *            the entd criterio vo
     * @return the entidad tipo dato vo
     */
    EntidadTipoDatoVO selectObject(final @Nonnull EntidadTipoDatoCriterioVO entdCriterioVO);
}
