package xeredi.argo.model.proceso.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoDAO.
 */
public interface ProcesoDAO {

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final ProcesoCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ProcesoVO> selectList(final ProcesoCriterioVO criterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ProcesoVO> selectList(final ProcesoCriterioVO criterio);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the proceso VO
     */
    ProcesoVO selectObject(final ProcesoCriterioVO criterio);

    /**
     * Insert.
     *
     * @param prbt
     *            the prbt
     */
    void insert(final ProcesoVO prbt);

    /**
     * Delete.
     *
     * @param prbt
     *            the prbt
     * @return the int
     */
    int delete(final ProcesoVO prbt);

    /**
     * Update iniciar.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int updateIniciar(final Long prbtId);

    /**
     * Update finalizar.
     *
     * @param prbt
     *            the prbt
     * @return the int
     */
    int updateFinalizar(final ProcesoVO prbt);
}
