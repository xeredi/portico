package xeredi.integra.model.metamodelo.bo;

import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.dao.I18nDAO;
import xeredi.integra.model.comun.vo.I18nCriterioVO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAdminBO.
 */
public class CodigoReferenciaBO {

    /** The cdrf dao. */
    CodigoReferenciaDAO cdrfDAO;

    /** The cdri dao. */
    I18nDAO i18nDAO;

    /**
     * Insert.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final CodigoReferenciaVO cdrfVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(i18nMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            i18nDAO = session.getMapper(I18nDAO.class);

            final IgBO igBO = new IgBO();

            if (cdrfDAO.exists(cdrfVO)) {
                throw new DuplicateInstanceException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            cdrfVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            cdrfDAO.insert(cdrfVO);

            for (final String language : i18nMap.keySet()) {
                final I18nVO i18nVO = i18nMap.get(language);

                i18nVO.setPrefix(I18nPrefix.cdrf);
                i18nVO.setExternalId(cdrfVO.getId());
                i18nVO.setLanguage(language);

                i18nDAO.insert(i18nVO);
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final CodigoReferenciaVO cdrfVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(i18nMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            i18nDAO = session.getMapper(I18nDAO.class);

            final int updated = cdrfDAO.update(cdrfVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            for (final String language : i18nMap.keySet()) {
                final I18nVO i18nVO = i18nMap.get(language);

                i18nVO.setPrefix(I18nPrefix.cdrf);
                i18nVO.setLanguage(language);
                i18nDAO.update(i18nVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(cdrfVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            i18nDAO = session.getMapper(I18nDAO.class);

            final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

            i18nCriterioVO.setPrefix(I18nPrefix.cdrf);
            i18nCriterioVO.setExternalId(cdrfVO.getId());

            i18nDAO.deleteList(i18nCriterioVO);

            final int deleted = cdrfDAO.delete(cdrfVO.getId());

            if (deleted == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            session.commit();
        }
    }

    /**
     * Select object.
     *
     * @param cdrfCriterioVO
     *            the cdrf criterio vo
     * @return the codigo referencia vo
     */
    public CodigoReferenciaVO selectObject(final CodigoReferenciaCriterioVO cdrfCriterioVO) {
        Preconditions.checkNotNull(cdrfCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            return cdrfDAO.selectObject(cdrfCriterioVO);
        }
    }

    /**
     * Select.
     *
     * @param cdrfId
     *            the cdrf id
     * @return the codigo referencia vo
     */
    public CodigoReferenciaVO select(final Long cdrfId) {
        Preconditions.checkNotNull(cdrfId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            return cdrfDAO.select(cdrfId);
        }
    }
}
