package xeredi.integra.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAdminBO.
 */
public class EntidadEntidadBO {

    /** The enti dao. */
    EntidadDAO entiDAO;

    /** The enen dao. */
    EntidadEntidadDAO enenDAO;

    /**
     * Insert.
     *
     * @param enenVO
     *            the enen vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final EntidadEntidadVO enenVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(enenVO);
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());
        Preconditions.checkNotNull(enenVO.getOrden());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);
        enenDAO = session.getMapper(EntidadEntidadDAO.class);

        try {
            final EntidadVO entiPadreVO = entiDAO.select(enenVO.getEntiPadreId());
            final EntidadVO entiHijaVO = entiDAO.select(enenVO.getEntiHija().getId());

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

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param enenVO
     *            the enen vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenVO);
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());
        Preconditions.checkNotNull(enenVO.getOrden());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        enenDAO = session.getMapper(EntidadEntidadDAO.class);

        try {
            final int updated = enenDAO.update(enenVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(EntidadEntidadVO.class.getName(), enenVO);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param enenVO
     *            the enen vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenVO);
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        enenDAO = session.getMapper(EntidadEntidadDAO.class);

        try {
            final int updated = enenDAO.delete(enenVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(EntidadEntidadVO.class.getName(), enenVO);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the list
     */
    public final List<EntidadEntidadVO> selectList(final EntidadEntidadCriterioVO enenCriterioVO) {
        Preconditions.checkNotNull(enenCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        enenDAO = session.getMapper(EntidadEntidadDAO.class);

        try {
            return enenDAO.selectList(enenCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select object.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the entidad entidad vo
     */
    public final EntidadEntidadVO selectObject(final EntidadEntidadCriterioVO enenCriterioVO) {
        Preconditions.checkNotNull(enenCriterioVO);
        Preconditions.checkNotNull(enenCriterioVO.getEntiPadreId());
        Preconditions.checkNotNull(enenCriterioVO.getEntiHijaId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        enenDAO = session.getMapper(EntidadEntidadDAO.class);

        try {
            return enenDAO.selectObject(enenCriterioVO);
        } finally {
            session.close();
        }
    }
}
