package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroBO.
 */
@Singleton
public class TipoSubparametroBO implements TipoSubparametro {

    /** The tpsp dao. */
    @Inject
    TipoSubparametroDAO tpspDAO;

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpspDAO.selectLabelValues(new TipoSubparametroCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO) {
        Preconditions.checkNotNull(tpspCriterioVO);

        return tpspDAO.selectList(tpspCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(tpspCriterioVO);

        final int count = tpspDAO.count(tpspCriterioVO);
        final List<TipoSubparametroVO> list = new ArrayList<>();

        if (count > offset) {
            list.addAll(tpspDAO.selectList(tpspCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(list, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoSubparametroVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final TipoSubparametroVO entiVO = tpspDAO.select(id);

        if (entiVO == null) {
            throw new Error("Tipo de subparametro no encontrado: " + id);
        }

        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        entiBO.fillDependencies(entiVO);

        return entiVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final TipoSubparametroVO tpspVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpspVO);

        final Long id = entiDAO.nextSequence();

        tpspVO.setId(id);
        tpspVO.setTipo(TipoEntidad.B);

        if (entiDAO.exists(tpspVO)) {
            throw new DuplicateInstanceException(TipoSubparametroVO.class.getName(), tpspVO);
        }

        entiDAO.insert(tpspVO);
        tpspDAO.insert(tpspVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoSubparametroVO tpspVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspVO);

        final int updated = tpspDAO.update(tpspVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspVO);
        }

        entiDAO.update(tpspVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long tpspId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspId);

        final int updated = tpspDAO.delete(tpspId);

        if (updated == 0) {
            throw new InstanceNotFoundException(TipoSubparametroVO.class.getName(), tpspId);
        }

        entiDAO.delete(tpspId);
    }

}
