package xeredi.integra.model.bo.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.dao.metamodelo.EntidadDAO;
import xeredi.integra.model.dao.metamodelo.TipoSubservicioDAO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAdminBO.
 */
@Singleton
public class TipoSubservicioBO implements TipoSubservicio {

    /** The tpss dao. */
    @Inject
    TipoSubservicioDAO tpssDAO;

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpssDAO.selectLabelValues(new TipoSubservicioCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO) {
        Preconditions.checkNotNull(tpssCriterioVO);

        return tpssDAO.selectList(tpssCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpssCriterioVO);

        final int count = tpssDAO.count(tpssCriterioVO);
        final List<TipoSubservicioVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(tpssDAO.selectList(tpssCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoSubservicioVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final TipoSubservicioVO entiVO = tpssDAO.select(id);

        if (entiVO == null) {
            throw new Error("Tipo de servicio no encontrado: " + id);
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
    public final void insert(final TipoSubservicioVO tpssVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpssVO);

        final Long id = entiDAO.nextSequence();

        tpssVO.setId(id);
        tpssVO.setTipo(TipoEntidad.P);

        if (entiDAO.exists(tpssVO)) {
            throw new DuplicateInstanceException(TipoSubservicioVO.class.getName(), tpssVO);
        }

        entiDAO.insert(tpssVO);
        tpssDAO.insert(tpssVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoSubservicioVO tpssVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssVO);

        final int updated = tpssDAO.update(tpssVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssVO);
        }

        entiDAO.update(tpssVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long tpssId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssId);

        final int updated = tpssDAO.delete(tpssId);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoSubservicioVO.class.getName(), tpssId);
        }

        entiDAO.delete(tpssId);
    }
}
