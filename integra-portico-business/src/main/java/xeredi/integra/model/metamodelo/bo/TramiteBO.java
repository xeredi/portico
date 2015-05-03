package xeredi.integra.model.metamodelo.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.TramiteDAO;
import xeredi.integra.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteBO.
 */
public final class TramiteBO {

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<TramiteVO> selectList(final @NonNull TramiteCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);

            return trmtDAO.selectList(criterio);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TramiteVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final TramiteCriterioVO criterio = new TramiteCriterioVO();

            criterio.setId(id);
            criterio.setIdioma(idioma);

            final TramiteVO trmt = trmtDAO.selectObject(criterio);

            if (trmt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.trmt, id);
            }

            return trmt;
        }
    }

    /**
     * Insert.
     *
     * @param trmt
     *            the trmt
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull TramiteVO trmt) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);
            final IgBO igBO = new IgBO();

            if (trmtDAO.exists(trmt)) {
                throw new DuplicateInstanceException(MessageI18nKey.trmt, trmt);
            }

            trmt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            trmtDAO.insert(trmt);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param trmt
     *            the trmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TramiteVO trmt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(trmt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteDAO trmtDAO = session.getMapper(TramiteDAO.class);

            if (trmtDAO.delete(trmt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.trmt, trmt);
            }

            session.commit();
        }
    }

}
