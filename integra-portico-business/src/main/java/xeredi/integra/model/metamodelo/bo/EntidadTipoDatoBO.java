package xeredi.integra.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
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
public final class EntidadTipoDatoBO {

    /**
     * Insert.
     *
     * @param entdVO
     *            the entd vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @Nonnull EntidadTipoDatoVO entdVO, final @Nonnull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
            final IgBO igBO = new IgBO();

            if (entdDAO.exists(entdVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.entd, entdVO);
            }

            entdVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            entdDAO.insert(entdVO);
            I18nBO.insertMap(session, I18nPrefix.entd, entdVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param entdVO
     *            the entd vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @Nonnull EntidadTipoDatoVO entdVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.update(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            I18nBO.updateMap(session, I18nPrefix.entd, entdVO.getId(), i18nMap);

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
    public void delete(final @Nonnull EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.delete(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            I18nBO.deleteMap(session, I18nPrefix.entd, entdVO.getId());

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
    public EntidadTipoDatoVO select(final @Nonnull Long entiId, final @Nonnull Long tpdtId, final String idioma)
            throws InstanceNotFoundException {
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

    /**
     * Select list.
     *
     * @param entdCriterio
     *            the entd criterio
     * @return the list
     */
    public List<EntidadTipoDatoVO> selectList(final @Nonnull EntidadTipoDatoCriterioVO entdCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            return entdDAO.selectList(entdCriterio);
        }
    }
}
