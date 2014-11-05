package xeredi.integra.model.metamodelo.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAdminBO.
 */
public class EntidadTipoDatoBO {
    /**
     * Insert.
     *
     * @param entdVO
     *            the entd vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final EntidadTipoDatoVO entdVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.exists(entdVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.entd, entdVO);
            }

            entdDAO.insert(entdVO);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param entdVO
     *            the entd vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.update(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param entdVO
     *            the entd vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.delete(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param entiId
     *            the enti id
     * @param tpdtId
     *            the tpdt id
     * @param idioma
     *            the idioma
     * @return the entidad tipo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final EntidadTipoDatoVO select(final Long entiId, final Long tpdtId, final String idioma)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(tpdtId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
            final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

            entdCriterioVO.setEntiId(entiId);
            entdCriterioVO.setTpdtId(tpdtId);
            entdCriterioVO.setIdioma(idioma);

            final EntidadTipoDatoVO entdVO = entdDAO.selectObject(entdCriterioVO);

            if (entdVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdCriterioVO);
            }

            return entdVO;
        }
    }
}
