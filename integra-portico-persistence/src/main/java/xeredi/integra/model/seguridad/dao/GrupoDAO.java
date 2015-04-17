package xeredi.integra.model.seguridad.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GrupoDAO.
 */
public interface GrupoDAO {

    /**
     * Exists.
     *
     * @param grpo
     *            the grpo
     * @return true, if successful
     */
    boolean exists(final GrupoVO grpo);

    /**
     * Insert.
     *
     * @param grpo
     *            the grpo
     */
    void insert(final GrupoVO grpo);

    /**
     * Update.
     *
     * @param grpo
     *            the grpo
     * @return the int
     */
    int update(final GrupoVO grpo);

    /**
     * Delete.
     *
     * @param grpo
     *            the grpo
     * @return the int
     */
    int delete(final GrupoVO grpo);

    /**
     * Select object.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the grupo vo
     */
    GrupoVO selectObject(final GrupoCriterioVO grpoCriterio);

    /**
     * Count.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the int
     */
    int count(final GrupoCriterioVO grpoCriterio);

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the list
     */
    List<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio);

}
