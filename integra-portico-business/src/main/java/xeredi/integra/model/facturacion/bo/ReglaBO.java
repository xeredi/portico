package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaBO.
 */
@Singleton
public class ReglaBO implements Regla {

    /** The rgla dao. */
    @Inject
    ReglaDAO rglaDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(rglaCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        final int count = rglaDAO.count(rglaCriterioVO);
        final List<ReglaVO> rglaList = new ArrayList<>();

        if (count >= offset) {
            rglaList.addAll(rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<ReglaVO>(rglaList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO) {
        Preconditions.checkNotNull(rglaCriterioVO);

        return rglaDAO.selectList(rglaCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(final ReglaVO rgla) throws OverlapException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());

        final IgBO igBO = new IgBO();

        if (rglaDAO.exists(rgla)) {
            rgla.setId(rglaDAO.selectId(rgla));

            if (rglaDAO.existsOverlap(rgla)) {
                throw new OverlapException(ReglaVO.class.getName(), rgla);
            }
        } else {
            rgla.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            rglaDAO.insert(rgla);
        }

        rgla.getRglv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        rglaDAO.insertVersion(rgla);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(final ReglaVO rgla) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        if (rglaDAO.existsOverlap(rgla)) {
            throw new OverlapException(ReglaVO.class.getName(), rgla);
        }

        final int updated = rglaDAO.updateVersion(rgla);

        if (updated == 0) {
            throw new InstanceNotFoundException(ReglaVO.class.getName(), rgla);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(final ReglaVO rgla) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        final int updated = rglaDAO.deleteVersion(rgla);

        if (updated == 0) {
            throw new InstanceNotFoundException(ReglaVO.class.getName(), rgla);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ReglaVO select(final ReglaCriterioVO rglaCriterioVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rglaCriterioVO);
        Preconditions.checkArgument(rglaCriterioVO.getRglvId() != null || rglaCriterioVO.getId() != null
                && rglaCriterioVO.getFechaVigencia() != null);

        final ReglaVO rgla = rglaDAO.selectObject(rglaCriterioVO);

        if (rgla == null) {
            throw new InstanceNotFoundException(ReglaVO.class.getName(), rglaCriterioVO);
        }

        return rgla;
    }

}
