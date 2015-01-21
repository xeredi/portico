package xeredi.integra.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.CampoAgregacionDAO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionBO.
 */
public final class CampoAgregacionBO {

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final CampoAgregacionVO vo) throws DuplicateInstanceException {
        Preconditions.checkNotNull(vo);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CampoAgregacionDAO cmagDAO = session.getMapper(CampoAgregacionDAO.class);

            if (cmagDAO.exists(vo)) {
                throw new DuplicateInstanceException(MessageI18nKey.cmag, vo);
            }

            cmagDAO.insert(vo);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final CampoAgregacionVO vo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vo);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CampoAgregacionDAO cmagDAO = session.getMapper(CampoAgregacionDAO.class);

            if (cmagDAO.update(vo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cmag, vo);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param vo
     *            the vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final CampoAgregacionVO vo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vo);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CampoAgregacionDAO cmagDAO = session.getMapper(CampoAgregacionDAO.class);

            if (cmagDAO.delete(vo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.cmag, vo);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param tpesId
     *            the tpes id
     * @param entdId
     *            the entd id
     * @param idioma
     *            the idioma
     * @return the campo agregacion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public CampoAgregacionVO select(final Long tpesId, final Long entdId, final String idioma)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpesId);
        Preconditions.checkNotNull(entdId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CampoAgregacionDAO cmagDAO = session.getMapper(CampoAgregacionDAO.class);
            final CampoAgregacionCriterioVO cmagCriterioVO = new CampoAgregacionCriterioVO();

            cmagCriterioVO.setTpesId(tpesId);
            cmagCriterioVO.setEntdId(entdId);

            final CampoAgregacionVO cmagVO = cmagDAO.selectObject(cmagCriterioVO);

            if (cmagVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.cmag, cmagCriterioVO);
            }

            return cmagVO;
        }
    }

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<CampoAgregacionVO> selectList(final CampoAgregacionCriterioVO criterioVO) {
        Preconditions.checkNotNull(criterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CampoAgregacionDAO cmapDAO = session.getMapper(CampoAgregacionDAO.class);

            return cmapDAO.selectList(criterioVO);
        }
    }

}
