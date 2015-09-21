package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAdminBO.
 */
public final class EntidadEntidadBO {
    /**
     * Insert.
     *
     * @param enenVO
     *            the enen vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final EntidadEntidadVO enenVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());
        Preconditions.checkNotNull(enenVO.getOrden());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);

            final EntidadCriterioVO entipadreCriterio = new EntidadCriterioVO();

            entipadreCriterio.setId(enenVO.getEntiPadreId());

            final EntidadVO entiPadreVO = entiDAO.selectObject(entipadreCriterio);

            final EntidadCriterioVO entihijaCriterio = new EntidadCriterioVO();

            entihijaCriterio.setId(enenVO.getEntiHija().getId());

            final EntidadVO entiHijaVO = entiDAO.selectObject(entihijaCriterio);

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
                throw new DuplicateInstanceException(MessageI18nKey.enen, enenVO);
            }

            enenDAO.insert(enenVO);

            session.commit();
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
    public void update(final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());
        Preconditions.checkNotNull(enenVO.getOrden());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final int updated = enenDAO.update(enenVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enen, enenVO);
            }

            session.commit();
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
    public void delete(final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenVO.getEntiPadreId());
        Preconditions.checkNotNull(enenVO.getEntiHija());
        Preconditions.checkNotNull(enenVO.getEntiHija().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final int updated = enenDAO.delete(enenVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enen, enenVO);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the list
     */
    public List<EntidadEntidadVO> selectList(final EntidadEntidadCriterioVO enenCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);

            return enenDAO.selectList(enenCriterioVO);
        }
    }

    /**
     * Select object.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the entidad entidad vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EntidadEntidadVO selectObject(final EntidadEntidadCriterioVO enenCriterioVO)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(enenCriterioVO.getEntiPadreId());
        Preconditions.checkNotNull(enenCriterioVO.getEntiHijaId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final EntidadEntidadVO enen = enenDAO.selectObject(enenCriterioVO);

            if (enen == null) {
                throw new InstanceNotFoundException(MessageI18nKey.enen, enenCriterioVO);
            }

            return enen;
        }
    }
}
