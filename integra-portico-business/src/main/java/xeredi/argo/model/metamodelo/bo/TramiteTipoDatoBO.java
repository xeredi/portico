package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.TramiteTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoBO.
 */
public final class TramiteTipoDatoBO {

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<TramiteTipoDatoVO> selectList(final @NonNull TramiteTipoDatoCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);

            return trtdDAO.selectList(criterio);
        }
    }

    /**
     * Select.
     *
     * @param trmtId
     *            the trmt id
     * @param tpdtId
     *            the tpdt id
     * @param idioma
     *            the idioma
     * @return the tramite tipo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TramiteTipoDatoVO select(final @NonNull Long trmtId, final @NonNull Long tpdtId, final String idioma)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);
            final TramiteTipoDatoCriterioVO criterio = new TramiteTipoDatoCriterioVO();

            criterio.setTrmtId(trmtId);
            criterio.setTpdtId(tpdtId);
            criterio.setIdioma(idioma);

            final TramiteTipoDatoVO trtd = trtdDAO.selectObject(criterio);

            if (trtd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.trtd, criterio);
            }

            return trtd;
        }
    }

    /**
     * Insert.
     *
     * @param trtd
     *            the trtd
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull TramiteTipoDatoVO trtd) throws DuplicateInstanceException {
        Preconditions.checkNotNull(trtd.getTrmtId());
        Preconditions.checkNotNull(trtd.isObligatorio());
        Preconditions.checkNotNull(trtd.getEntd());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);

            if (trtdDAO.exists(trtd)) {
                throw new DuplicateInstanceException(MessageI18nKey.trtd, trtd);
            }

            trtdDAO.insert(trtd);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param trtd
     *            the trtd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TramiteTipoDatoVO trtd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(trtd.getTrmtId());
        Preconditions.checkNotNull(trtd.isObligatorio());
        Preconditions.checkNotNull(trtd.getEntd());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);

            if (trtdDAO.delete(trtd) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.trtd, trtd);
            }

            session.commit();
        }
    }
}