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
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAdminBO.
 */
public final class CodigoReferenciaBO {

    /**
     * Insert.
     *
     * @param cdrf
     *            the cdrf
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull CodigoReferenciaVO cdrf, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            if (cdrfDAO.exists(cdrf)) {
                throw new DuplicateInstanceException(MessageI18nKey.cdrf, cdrf);
            }

            IgUtilBO.assignNextVal(cdrf);
            cdrfDAO.insert(cdrf);

            I18nUtilBO.insertMap(session, cdrf, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param cdrf
     *            the cdrf
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull CodigoReferenciaVO cdrf, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final int updated = cdrfDAO.update(cdrf);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
            }

            I18nUtilBO.updateMap(session, cdrf, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param cdrf
     *            the cdrf
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull CodigoReferenciaVO cdrf) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrf.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nUtilBO.deleteMap(session, cdrf);

            final int deleted = cdrfDAO.delete(cdrf);

            if (deleted == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
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
    public CodigoReferenciaVO select(final @NonNull Long cdrfId, final String idioma) throws InstanceNotFoundException {
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
    public List<CodigoReferenciaVO> selectList(final @NonNull Long tpdtId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

            cdrfCriterioVO.setTpdtId(tpdtId);
            cdrfCriterioVO.setIdioma(idioma);

            return cdrfDAO.selectList(cdrfCriterioVO);
        }
    }
}
