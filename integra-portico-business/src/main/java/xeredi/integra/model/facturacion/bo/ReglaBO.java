package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.dao.ReglaIncompatibleDAO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
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

    @Inject
    ReglaIncompatibleDAO rginDAO;

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
    public List<ReglaVO> selectList(ReglaCriterioVO rglaCriterioVO) {
        Preconditions.checkNotNull(rglaCriterioVO);

        return rglaDAO.selectList(rglaCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ReglaVO select(final ReglaCriterioVO rglaCriterioVO) {
        Preconditions.checkNotNull(rglaCriterioVO);
        Preconditions.checkArgument(rglaCriterioVO.getRglvId() != null || rglaCriterioVO.getId() != null
                && rglaCriterioVO.getFechaVigencia() != null);

        return rglaDAO.selectObject(rglaCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ReglaIncompatibleVO> selectRginList(final ReglaIncompatibleCriterioVO rginCriterioVO) {
        Preconditions.checkNotNull(rginCriterioVO);

        return rginDAO.selectList(rginCriterioVO);
    }

}
