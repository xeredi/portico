package xeredi.argo.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAdminBO.
 */
public final class CodigoReferenciaBO {
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
    public void insert(final CodigoReferenciaVO cdrfVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final IgBO igBO = new IgBO();

            if (cdrfDAO.exists(cdrfVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.cdrf, cdrfVO);
            }

            cdrfVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            cdrfDAO.insert(cdrfVO);

            I18nBO.insertMap(session, I18nPrefix.cdrf, cdrfVO.getId(), i18nMap);

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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final int updated = cdrfDAO.update(cdrfVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrfVO);
            }

            I18nBO.updateMap(session, I18nPrefix.cdrf, cdrfVO.getId(), i18nMap);

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
    public void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.cdrf, cdrfVO.getId());

            final int deleted = cdrfDAO.delete(cdrfVO);

            if (deleted == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrfVO);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param cdrfId
     *            the cdrf id
     * @param idioma
     *            the idioma
     * @return the codigo referencia vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public CodigoReferenciaVO select(final Long cdrfId, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

            cdrfCriterioVO.setId(cdrfId);
            cdrfCriterioVO.setIdioma(idioma);

            final CodigoReferenciaVO cdrf = cdrfDAO.selectObject(cdrfCriterioVO);

            if (cdrf == null) {
                throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrfId);
            }

            return cdrf;
        }
    }

    /**
     * Select list.
     *
     * @param tpdtId
     *            the tpdt id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<CodigoReferenciaVO> selectList(final Long tpdtId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

            cdrfCriterioVO.setTpdtId(tpdtId);
            cdrfCriterioVO.setIdioma(idioma);

            return cdrfDAO.selectList(cdrfCriterioVO);
        }
    }
}