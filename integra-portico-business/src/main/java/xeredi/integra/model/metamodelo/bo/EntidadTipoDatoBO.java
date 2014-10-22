package xeredi.integra.model.metamodelo.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAdminBO.
 */
public class EntidadTipoDatoBO {

    /** The enti dao. */
    EntidadDAO entiDAO;

    /** The entd dao. */
    EntidadTipoDatoDAO entdDAO;

    /**
     * Insert.
     *
     * @param entdVO
     *            the entd vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final EntidadTipoDatoVO entdVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entiDAO = session.getMapper(EntidadDAO.class);
        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

        try {
            if (entdDAO.exists(entdVO)) {
                throw new DuplicateInstanceException(EntidadTipoDatoVO.class.getName(), entdVO);
            }

            entdDAO.insert(entdVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param entdVO
     *            the entd vo
     */
    public final void update(final EntidadTipoDatoVO entdVO) {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

        try {
            final int updated = entdDAO.update(entdVO);

            if (updated == 0) {
                throw new Error("Dato de entidad no encontrado: " + entdVO);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param entdVO
     *            the entd vo
     */
    public final void delete(final EntidadTipoDatoVO entdVO) {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getEntiId());
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

        try {
            final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

            entdCriterioVO.setEntiId(entdVO.getEntiId());
            entdCriterioVO.setTpdtId(entdVO.getTpdt().getId());

            entdDAO.deleteCriterio(entdCriterioVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param entiId
     *            the enti id
     * @param tpdtId
     *            the tpdt id
     * @return the entidad tipo dato vo
     */
    public final EntidadTipoDatoVO select(final Long entiId, final Long tpdtId, final String idioma) {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(tpdtId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

        try {
            final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

            entdCriterioVO.setEntiId(entiId);
            entdCriterioVO.setTpdtId(tpdtId);
            entdCriterioVO.setIdioma(idioma);

            final EntidadTipoDatoVO entdVO = entdDAO.selectObject(entdCriterioVO);

            if (entdVO == null) {
                throw new Error("Dato de entidad no encontrado: " + entdCriterioVO);
            }

            return entdVO;
        } finally {
            session.close();
        }
    }
}
