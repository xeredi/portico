package xeredi.integra.model.facturacion.bo;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.ReglaIncompatibleDAO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleBO.
 */
@Singleton
public class ReglaIncompatibleBO implements ReglaIncompatible {

    /** The rgin dao. */
    @Inject
    ReglaIncompatibleDAO rginDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(final ReglaIncompatibleVO rgin) throws OverlapException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgla1Id());
        Preconditions.checkNotNull(rgin.getRgla2());
        Preconditions.checkNotNull(rgin.getRgla2().getId());
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getFini());

        final IgBO igBO = new IgBO();

        if (rginDAO.exists(rgin)) {
            rgin.setId(rginDAO.selectId(rgin));

            if (rginDAO.existsOverlap(rgin)) {
                throw new OverlapException(ReglaIncompatibleVO.class.getName(), rgin);
            }
        } else {
            rgin.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            rginDAO.insert(rgin);
        }

        rgin.getRgiv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        rginDAO.insertVersion(rgin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getId());
        Preconditions.checkNotNull(rgin.getRgiv().getFini());

        if (rginDAO.existsOverlap(rgin)) {
            throw new OverlapException(ReglaIncompatibleVO.class.getName(), rgin);
        }

        final int updated = rginDAO.updateVersion(rgin);

        if (updated == 0) {
            throw new InstanceNotFoundException(ReglaIncompatibleVO.class.getName(), rgin);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(final ReglaIncompatibleVO rgin) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgin);
        Preconditions.checkNotNull(rgin.getRgiv());
        Preconditions.checkNotNull(rgin.getRgiv().getId());

        final int updated = rginDAO.deleteVersion(rgin);

        if (updated == 0) {
            throw new InstanceNotFoundException(ReglaIncompatibleVO.class.getName(), rgin);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ReglaIncompatibleVO select(final ReglaIncompatibleCriterioVO rginCriterio) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rginCriterio);

        final ReglaIncompatibleVO rgin = rginDAO.selectObject(rginCriterio);

        if (rgin == null) {
            throw new InstanceNotFoundException(ReglaIncompatibleVO.class.getName(), rginCriterio);
        }

        return rgin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO rginCriterio) {
        Preconditions.checkNotNull(rginCriterio);

        return rginDAO.selectList(rginCriterio);
    }

}
