package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.CargoDAO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(final CargoVO crgo) throws OverlapException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getFini());
        Preconditions.checkNotNull(crgo.getTpsr());
        Preconditions.checkNotNull(crgo.getTpsr().getId());

        final IgBO igBO = new IgBO();

        if (crgoDAO.exists(crgo)) {
            crgo.setId(crgoDAO.selectId(crgo));

            if (crgoDAO.existsOverlap(crgo)) {
                throw new OverlapException(CargoVO.class.getName(), crgo);
            }
        } else {
            crgo.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            crgoDAO.insert(crgo);
        }

        crgo.getCrgv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        crgoDAO.insertVersion(crgo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(final CargoVO crgo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final int updated = crgoDAO.update(crgo);

        if (updated == 0) {
            throw new InstanceNotFoundException(CargoVO.class.getName(), crgo);
        }

        crgoDAO.updateVersion(crgo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(final CargoVO crgo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final int updated = crgoDAO.deleteVersion(crgo);

        if (updated == 0) {
            throw new InstanceNotFoundException(CargoVO.class.getName(), crgo);
        }
    }

}
