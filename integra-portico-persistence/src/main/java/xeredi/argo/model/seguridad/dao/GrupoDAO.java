package xeredi.argo.model.seguridad.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import lombok.NonNull;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

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
    boolean exists(@NonNull final GrupoVO grpo);

    /**
     * Insert.
     *
     * @param grpo
     *            the grpo
     */
    void insert(@NonNull final GrupoVO grpo);

    /**
     * Update.
     *
     * @param grpo
     *            the grpo
     * @return the int
     */
    int update(@NonNull final GrupoVO grpo);

    /**
     * Delete.
     *
     * @param grpo
     *            the grpo
     * @return the int
     */
    int delete(@NonNull final GrupoVO grpo);

    /**
     * Count.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the int
     */
    int count(@NonNull final GrupoCriterioVO grpoCriterio);

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<GrupoVO> selectList(@NonNull final GrupoCriterioVO grpoCriterio, @NonNull final RowBounds bounds);

    /**
     * Select list.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the list
     */
    List<GrupoVO> selectList(@NonNull final GrupoCriterioVO grpoCriterio);

    /**
     * Select object.
     *
     * @param grpoCriterio
     *            the grpo criterio
     * @return the grupo VO
     */
    GrupoVO selectObject(@NonNull final GrupoCriterioVO grpoCriterio);
}
