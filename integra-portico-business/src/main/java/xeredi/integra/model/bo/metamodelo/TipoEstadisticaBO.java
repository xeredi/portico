package xeredi.integra.model.bo.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.dao.metamodelo.EntidadDAO;
import xeredi.integra.model.dao.metamodelo.TipoEstadisticaDAO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaBO.
 */
@Singleton
public class TipoEstadisticaBO implements TipoEstadistica {
    @Inject
    TipoEstadisticaDAO tpesDAO;

    @Inject
    EntidadDAO entiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpesDAO.selectLabelValues(new TipoEstadisticaCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO) {
        Preconditions.checkNotNull(tpesCriterioVO);

        return tpesDAO.selectList(tpesCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpesCriterioVO);

        final int count = tpesDAO.count(tpesCriterioVO);
        final List<TipoEstadisticaVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(tpesDAO.selectList(tpesCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoEstadisticaVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final TipoEstadisticaVO entiVO = tpesDAO.select(id);

        if (entiVO == null) {
            throw new Error("Tipo de estadistica no encontrado: " + id);
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
    public final void insert(final TipoEstadisticaVO tpesVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpesVO);

        final Long id = entiDAO.nextSequence();

        tpesVO.setId(id);
        tpesVO.setTipo(TipoEntidad.E);

        if (entiDAO.exists(tpesVO)) {
            throw new DuplicateInstanceException(TipoEstadisticaVO.class.getName(), tpesVO);
        }

        entiDAO.insert(tpesVO);
        tpesDAO.insert(tpesVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoEstadisticaVO tpesVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesVO);

        final int updated = tpesDAO.update(tpesVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoEstadisticaVO.class.getName(), tpesVO);
        }

        entiDAO.update(tpesVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long tpesId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesId);

        final int updated = tpesDAO.delete(tpesId);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoEstadisticaVO.class.getName(), tpesId);
        }

        entiDAO.delete(tpesId);
    }

}
