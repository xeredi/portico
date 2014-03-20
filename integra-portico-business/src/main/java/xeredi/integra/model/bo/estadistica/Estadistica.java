package xeredi.integra.model.bo.estadistica;

import java.util.List;

import xeredi.integra.model.vo.estadistica.EstadisticaCriterioVO;
import xeredi.integra.model.vo.estadistica.EstadisticaVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

public interface Estadistica {
    PaginatedList<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO, final int offset,
            final int limit);

    List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO);

    EstadisticaVO selectObject(final EstadisticaCriterioVO estdCriterioVO) throws InstanceNotFoundException;
}
