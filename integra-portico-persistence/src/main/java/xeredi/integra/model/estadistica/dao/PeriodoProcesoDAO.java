package xeredi.integra.model.estadistica.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PeriodoProcesoDAO.
 */
public interface PeriodoProcesoDAO {

    /**
     * Exists.
     *
     * @param peprVO
     *            the pepr vo
     * @return true, if successful
     */
    boolean exists(final PeriodoProcesoVO peprVO);

    /**
     * Insert.
     *
     * @param peprVO
     *            the pepr vo
     */
    void insert(final PeriodoProcesoVO peprVO);

    /**
     * Delete.
     *
     * @param peprId
     *            the pepr id
     * @return the int
     */
    int delete(final Long peprId);

    /**
     * Select.
     *
     * @param peprId
     *            the pepr id
     * @return the periodo proceso vo
     */
    PeriodoProcesoVO select(final Long peprId);

    /**
     * Select object.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @return the periodo proceso vo
     */
    PeriodoProcesoVO selectObject(final PeriodoProcesoCriterioVO peprCriterioVO);

    /**
     * Count.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @return the int
     */
    int selectCount(final PeriodoProcesoCriterioVO peprCriterioVO);

    /**
     * Select list.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @return the list
     */
    List<PeriodoProcesoVO> selectList(final PeriodoProcesoCriterioVO peprCriterioVO);

    /**
     * Select list.
     *
     * @param peprCriterioVO
     *            the pepr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<PeriodoProcesoVO> selectPaginatedList(final PeriodoProcesoCriterioVO peprCriterioVO, final RowBounds bounds);
}
