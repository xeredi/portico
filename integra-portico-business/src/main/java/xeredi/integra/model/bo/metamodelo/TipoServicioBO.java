package xeredi.integra.model.bo.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.dao.metamodelo.EntidadDAO;
import xeredi.integra.model.dao.metamodelo.TipoServicioDAO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoServicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAdminBO.
 */
@Singleton
public class TipoServicioBO implements TipoServicio {

    /** The tpsr dao. */
    @Inject
    TipoServicioDAO tpsrDAO;

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpsrDAO.selectLabelValues(new TipoServicioCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO) {
        Preconditions.checkNotNull(tpsrCriterioVO);

        return tpsrDAO.selectList(tpsrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpsrCriterioVO);

        final int count = tpsrDAO.count(tpsrCriterioVO);
        final List<TipoServicioVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(tpsrDAO.selectList(tpsrCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoServicioVO select(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final TipoServicioVO entiVO = tpsrDAO.select(id);

        if (entiVO == null) {
            throw new InstanceNotFoundException(TipoServicioVO.class.getName(), id);
        }

        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        entiBO.fillDependencies(entiVO);

        return entiVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final TipoServicioVO tpsrVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpsrVO);

        final Long id = entiDAO.nextSequence();

        tpsrVO.setId(id);
        tpsrVO.setTipo(TipoEntidad.P);

        if (entiDAO.exists(tpsrVO)) {
            throw new DuplicateInstanceException(TipoServicioVO.class.getName(), tpsrVO);
        }

        entiDAO.insert(tpsrVO);
        tpsrDAO.insert(tpsrVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoServicioVO tpsrVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsrVO);

        final int updated = tpsrDAO.update(tpsrVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrVO);
        }

        entiDAO.update(tpsrVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long tpsrId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsrId);

        final int updated = tpsrDAO.delete(tpsrId);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoServicioVO.class.getName(), tpsrId);
        }

        entiDAO.delete(tpsrId);
    }

}
