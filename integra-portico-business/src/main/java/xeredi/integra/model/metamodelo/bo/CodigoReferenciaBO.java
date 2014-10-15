package xeredi.integra.model.metamodelo.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.integra.model.metamodelo.dao.CodigoReferenciaI18nDAO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaI18nCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaI18nVO;
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
    CodigoReferenciaI18nDAO cdriDAO;

    /**
     * Insert.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final CodigoReferenciaVO cdrfVO, final Map<String, CodigoReferenciaI18nVO> cdriMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(cdrfVO);
        Preconditions.checkNotNull(cdriMap);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
        cdriDAO = session.getMapper(CodigoReferenciaI18nDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (cdrfDAO.exists(cdrfVO)) {
                throw new DuplicateInstanceException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            cdrfVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            cdrfDAO.insert(cdrfVO);

            for (final String language : cdriMap.keySet()) {
                final CodigoReferenciaI18nVO cdriVO = cdriMap.get(language);

                cdriVO.setCdrfId(cdrfVO.getId());
                cdriVO.setIdioma(language);
                cdriDAO.insert(cdriVO);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param cdrfVO
     *            the cdrf vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final CodigoReferenciaVO cdrfVO, final Map<String, CodigoReferenciaI18nVO> cdriMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
        cdriDAO = session.getMapper(CodigoReferenciaI18nDAO.class);

        try {
            final int updated = cdrfDAO.update(cdrfVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            for (final String language : cdriMap.keySet()) {
                final CodigoReferenciaI18nVO cdriVO = cdriMap.get(language);

                cdriVO.setIdioma(language);
                cdriDAO.update(cdriVO);
            }

            session.commit();
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
        cdriDAO = session.getMapper(CodigoReferenciaI18nDAO.class);

        try {

            final CodigoReferenciaI18nCriterioVO cdriCriterioVO = new CodigoReferenciaI18nCriterioVO();

            cdriCriterioVO.setCdrfId(cdrfVO.getId());
            cdriDAO.deleteList(cdriCriterioVO);

            final int deleted = cdrfDAO.delete(cdrfVO.getId());

            if (deleted == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            session.commit();
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            return cdrfDAO.selectObject(cdrfCriterioVO);
        } finally {
            session.close();
        }
    }

    public CodigoReferenciaVO select(final Long cdrfId) {
        Preconditions.checkNotNull(cdrfId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            return cdrfDAO.select(cdrfId);
        } finally {
            session.close();
        }
    }

    /**
     * Select i18n map.
     *
     * @param cdrfId
     *            the cdrf id
     * @return the map
     */
    public Map<String, CodigoReferenciaI18nVO> selectI18nMap(final Long cdrfId) {
        Preconditions.checkNotNull(cdrfId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        cdriDAO = session.getMapper(CodigoReferenciaI18nDAO.class);

        try {
            final CodigoReferenciaI18nCriterioVO criterioVO = new CodigoReferenciaI18nCriterioVO();

            criterioVO.setCdrfId(cdrfId);

            final List<CodigoReferenciaI18nVO> list = cdriDAO.selectList(criterioVO);
            final Map<String, CodigoReferenciaI18nVO> map = new HashMap<>();

            for (final CodigoReferenciaI18nVO vo : list) {
                map.put(vo.getIdioma(), vo);
            }

            return map;
        } finally {
            session.close();
        }
    }
}
