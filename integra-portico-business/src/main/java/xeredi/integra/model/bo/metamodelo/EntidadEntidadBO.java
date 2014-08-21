package xeredi.integra.model.bo.metamodelo;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAdminBO.
 */
@Singleton
public class EntidadEntidadBO implements EntidadEntidad {

    /** The enti dao. */
    @Inject
    EntidadDAO entiDAO;

    /** The enen dao. */
    @Inject
    EntidadEntidadDAO enenDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final EntidadEntidadVO enenVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(enenVO);

        final EntidadVO entiPadreVO = entiDAO.select(enenVO.getEntiPadreId());
        final EntidadVO entiHijaVO = entiDAO.select(enenVO.getEntiHijaId());

        if (entiPadreVO.getTipo() == TipoEntidad.P
                && (entiHijaVO.getTipo() == TipoEntidad.T || entiHijaVO.getTipo() == TipoEntidad.S)) {
            throw new Error("Una entidad de tipo maestro no puede ser padre de entidades asociadas a servicios: "
                    + enenVO);
        }
        if (entiPadreVO.getTipo() == TipoEntidad.S && entiHijaVO.getTipo() == TipoEntidad.T) {
            throw new Error(
                    "Una entidad de tipo subservicio no puede ser padre de entidades asociadas a tipos de servicio: "
                            + enenVO);
        }

        if (enenDAO.exists(enenVO)) {
            throw new DuplicateInstanceException(EntidadEntidadVO.class.getName(), enenVO);
        }

        enenDAO.insert(enenVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenVO);

        final int updated = enenDAO.delete(enenVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(EntidadEntidadVO.class.getName(), enenVO);
        }
    }
}
