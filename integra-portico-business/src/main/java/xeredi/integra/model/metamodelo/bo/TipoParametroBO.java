package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoParametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAdminBO.
 */
@Singleton
public class TipoParametroBO implements TipoParametro {

    /** The tppr dao. */
    @Inject
    TipoParametroDAO tpprDAO;

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpprDAO.selectLabelValues(new TipoParametroCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO) {
        Preconditions.checkNotNull(tpprCriterioVO);

        return tpprDAO.selectList(tpprCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpprCriterioVO);

        final int count = tpprDAO.count(tpprCriterioVO);
        final List<TipoParametroVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoParametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final TipoParametroVO entiVO = tpprDAO.select(id);

        if (entiVO == null) {
            throw new Error("Tipo de parametro no encontrado: " + id);
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
    public final void insert(final TipoParametroVO tpprVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpprVO);

        final Long id = entiDAO.nextSequence();

        tpprVO.setId(id);
        tpprVO.setTipo(TipoEntidad.P);

        if (entiDAO.exists(tpprVO)) {
            throw new DuplicateInstanceException(TipoParametroVO.class.getName(), tpprVO);
        }

        entiDAO.insert(tpprVO);
        tpprDAO.insert(tpprVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoParametroVO tpprVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpprVO);

        final int updated = tpprDAO.update(tpprVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprVO);
        }

        entiDAO.update(tpprVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long tpprId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpprId);

        final int updated = tpprDAO.delete(tpprId);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoParametroVO.class.getName(), tpprId);
        }

        entiDAO.delete(tpprId);
    }
}
