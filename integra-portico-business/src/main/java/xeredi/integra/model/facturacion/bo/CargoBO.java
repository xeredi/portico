package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.facturacion.dao.CargoDAO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoBO.
 */
@Singleton
public class CargoBO implements Cargo {

    /** The crgo dao. */
    @Inject
    CargoDAO crgoDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<CargoVO> selectList(final CargoCriterioVO crgoCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(crgoCriterioVO);

        final int count = crgoDAO.count(crgoCriterioVO);
        final List<CargoVO> crgoList = new ArrayList<>();

        if (count >= offset) {
            crgoList.addAll(crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<CargoVO>(crgoList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CargoVO select(final CargoCriterioVO crgoCriterioVO) {
        Preconditions.checkNotNull(crgoCriterioVO);
        Preconditions.checkArgument(crgoCriterioVO.getCrgvId() != null || crgoCriterioVO.getId() != null
                && crgoCriterioVO.getFechaVigencia() != null);

        return crgoDAO.selectObject(crgoCriterioVO);
    }

}
