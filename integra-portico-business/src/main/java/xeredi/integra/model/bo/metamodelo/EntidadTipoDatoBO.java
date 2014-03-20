package xeredi.integra.model.bo.metamodelo;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.metamodelo.EntidadDAO;
import xeredi.integra.model.dao.metamodelo.EntidadTipoDatoDAO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.util.exception.DuplicateInstanceException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAdminBO.
 */
@Singleton
public class EntidadTipoDatoBO implements EntidadTipoDato {

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /** The entd dao. */
    @Inject
    EntidadTipoDatoDAO entdDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final EntidadTipoDatoVO entdVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        if (entdDAO.exists(entdVO)) {
            throw new DuplicateInstanceException(EntidadTipoDatoVO.class.getName(), entdVO);
        }

        final EntidadVO entiVO = entiDAO.select(entdVO.getEntiId());
        // FIXME Acabar

        entdDAO.insert(entdVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final EntidadTipoDatoVO entdVO) {
        Preconditions.checkNotNull(entdVO);

        final int updated = entdDAO.update(entdVO);

        if (updated == 0) {
            throw new Error("Dato de entidad no encontrado: " + entdVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final EntidadTipoDatoVO select(final Long entiId, final Long tpdtId) {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(tpdtId);

        final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

        entdCriterioVO.setEntiId(entiId);
        entdCriterioVO.setTpdtId(tpdtId);

        final EntidadTipoDatoVO entdVO = entdDAO.selectObject(entdCriterioVO);

        if (entdVO == null) {
            throw new Error("Dato de entidad no encontrado: " + entdCriterioVO);
        }

        return entdVO;
    }
}
