package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.TramiteTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.util.SqlMapperLocator;

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
    public List<TramiteTipoDatoVO> selectList(@NonNull final TramiteTipoDatoCriterioVO criterio) {
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
    public TramiteTipoDatoVO select(@NonNull final Long trmtId, @NonNull final Long tpdtId, final String idioma)
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
    public void insert(@NonNull final TramiteTipoDatoVO trtd) throws DuplicateInstanceException {
        Preconditions.checkNotNull(trtd.getTrmtId());
        Preconditions.checkNotNull(trtd.getObligatorio());
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
     * Update.
     *
     * @param trtd
     *            the trtd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(trtd.getTrmtId());
        Preconditions.checkNotNull(trtd.getObligatorio());
        Preconditions.checkNotNull(trtd.getEntd());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt());
        Preconditions.checkNotNull(trtd.getEntd().getTpdt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);

            if (trtdDAO.update(trtd) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.trtd, trtd);
            }

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
    public void delete(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(trtd.getTrmtId());
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
