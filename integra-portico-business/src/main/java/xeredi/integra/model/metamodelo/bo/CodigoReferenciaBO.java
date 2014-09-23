package xeredi.integra.model.metamodelo.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

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
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final CodigoReferenciaVO cdrfVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cdrfVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            if (cdrfDAO.exists(cdrfVO)) {
                throw new DuplicateInstanceException(CodigoReferenciaVO.class.getName(), cdrfVO);
            }

            cdrfDAO.insert(cdrfVO);

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
    public void update(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            final int updated = cdrfDAO.update(cdrfVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            final int deleted = cdrfDAO.delete(cdrfVO);

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            return cdrfDAO.selectObject(cdrfCriterioVO);
        } finally {
            session.close();
        }
    }
}
