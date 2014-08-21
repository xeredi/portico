package xeredi.integra.model.proceso.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoDAO.
 */
public interface ProcesoDAO {

    /**
     * Insert.
     *
     * @param prbtVO
     *            the prbt vo
     */
    void insert(final ProcesoVO prbtVO);

    /**
     * Delete.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int delete(final Long prbtId);

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
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int updateFinalizar(final Long prbtId);

    /**
     * Select.
     *
     * @param prbtId
     *            the prbt id
     * @return the proceso vo
     */
    ProcesoVO select(final Long prbtId);

    /**
     * Select object.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @return the proceso vo
     */
    ProcesoVO selectObject(final ProcesoCriterioVO prbtCriterioVO);

    /**
     * Count.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @return the int
     */
    int selectCount(final ProcesoCriterioVO prbtCriterioVO);

    /**
     * Select list.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @return the list
     */
    List<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO);
}
