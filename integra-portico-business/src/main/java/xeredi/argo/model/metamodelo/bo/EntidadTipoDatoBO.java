package xeredi.argo.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.util.mybatis.SqlMapperLocator;

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
    public void insert(final EntidadTipoDatoVO entdVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.exists(entdVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.entd, entdVO);
            }

            IgUtilBO.assignNextVal(entdVO);

            entdDAO.insert(entdVO);
            I18nUtilBO.insertMap(session, entdVO, i18nMap);

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
    public void update(final EntidadTipoDatoVO entdVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.update(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            I18nUtilBO.updateMap(session, entdVO, i18nMap);

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
    public void delete(final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entdVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            if (entdDAO.delete(entdVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
            }

            I18nUtilBO.deleteMap(session, entdVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the entidad tipo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EntidadTipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);
            final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

            entdCriterioVO.setId(id);
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
    public List<EntidadTipoDatoVO> selectList(final EntidadTipoDatoCriterioVO entdCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

            return entdDAO.selectList(entdCriterio);
        }
    }
}
