package xeredi.integra.model.estadistica.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PeriodoProcesoDAO.
 */
public interface PeriodoProcesoDAO extends CrudDAO<PeriodoProcesoVO, PeriodoProcesoCriterioVO> {
    /**
     * Select.
     *
     * @param peprId
     *            the pepr id
     * @return the periodo proceso vo
     */
    PeriodoProcesoVO select(final Long peprId);
}
