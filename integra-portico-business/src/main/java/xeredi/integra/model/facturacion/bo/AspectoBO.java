package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
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
    public PaginatedList<AspectoVO> selectList(final AspectoCriterioVO aspcCriterioVO, final int offset, final int limit) {
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
    public AspectoVO select(final AspectoCriterioVO aspcCriterioVO) {
        Preconditions.checkNotNull(aspcCriterioVO);
        Preconditions.checkArgument(aspcCriterioVO.getAspvId() != null || aspcCriterioVO.getId() != null
                && aspcCriterioVO.getFechaVigencia() != null);

        return aspcDAO.selectObject(aspcCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(final AspectoVO aspc) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        if (aspcDAO.exists(aspc)) {
            throw new DuplicateInstanceException(AspectoVO.class.getName(), aspc);
        }

        aspcDAO.insert(aspc);
        aspcDAO.insertVersion(aspc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(final AspectoVO aspc) throws InstanceNotFoundException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getId());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        final int updated = aspcDAO.update(aspc);

        if (updated == 0) {
            throw new InstanceNotFoundException(AspectoVO.class.getName(), aspc);
        }

        aspcDAO.updateVersion(aspc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void duplicate(final AspectoVO aspc) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        if (aspcDAO.exists(aspc)) {
            throw new DuplicateInstanceException(AspectoVO.class.getName(), aspc);
        }

        aspcDAO.insert(aspc);
        aspcDAO.insertVersion(aspc);
    }

}
