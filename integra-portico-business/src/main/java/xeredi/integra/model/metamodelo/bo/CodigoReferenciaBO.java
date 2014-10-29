package xeredi.integra.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
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

            final IgBO igBO = new IgBO();

            if (cdrfDAO.exists(cdrfVO)) {
                throw new DuplicateInstanceException(CodigoReferenciaVO.class.getName(), cdrfVO);
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
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(i18nMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            final int updated = cdrfDAO.update(cdrfVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
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
    public final void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(cdrfVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.cdrf, cdrfVO.getId());

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
     * @param idioma
     *            the idioma
     * @return the codigo referencia vo
     */
    public CodigoReferenciaVO select(final Long cdrfId, final String idioma) {
        Preconditions.checkNotNull(cdrfId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

            cdrfCriterioVO.setId(cdrfId);
            cdrfCriterioVO.setIdioma(idioma);

            return cdrfDAO.selectObject(cdrfCriterioVO);
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
        Preconditions.checkNotNull(tpdtId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

            cdrfCriterioVO.setTpdtId(tpdtId);
            cdrfCriterioVO.setIdioma(idioma);

            return cdrfDAO.selectList(cdrfCriterioVO);
        }
    }
}
