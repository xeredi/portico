package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoBO.
 */
@Singleton
public class AspectoBO implements Aspecto {

    /** The aspc dao. */
    @Inject
    AspectoDAO aspcDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<AspectoVO> selectList(AspectoCriterioVO aspcCriterioVO, int offset, int limit) {
        Preconditions.checkNotNull(aspcCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        final int count = aspcDAO.count(aspcCriterioVO);
        final List<AspectoVO> aspcList = new ArrayList<>();

        if (count >= offset) {
            aspcList.addAll(aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<AspectoVO>(aspcList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public AspectoVO selectObject(AspectoCriterioVO aspcCriterioVO) {
        Preconditions.checkNotNull(aspcCriterioVO);
        Preconditions.checkArgument(aspcCriterioVO.getId() != null && aspcCriterioVO.getFechaVigencia() != null);

        return aspcDAO.selectObject(aspcCriterioVO);
    }

}
