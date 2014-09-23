package xeredi.integra.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoBO.
 */
public class EntidadGrupoDatoBO {

    /** The engd dao. */
    EntidadGrupoDatoDAO engdDAO;

    /**
     * Insert.
     *
     * @param engdVO
     *            the engd vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final EntidadGrupoDatoVO engdVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());
        Preconditions.checkNotNull(engdVO.getEtiqueta());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            if (engdDAO.exists(engdVO)) {
                throw new DuplicateInstanceException(EntidadGrupoDatoVO.class.getName(), engdVO);
            }

            engdDAO.insert(engdVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param engdVO
     *            the engd vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final EntidadGrupoDatoVO engdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());
        Preconditions.checkNotNull(engdVO.getEtiqueta());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            if (engdDAO.update(engdVO) == 0) {
                throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdVO);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param entiId
     *            the enti id
     * @param numero
     *            the numero
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final Long entiId, final Integer numero) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(numero);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiId);
            engdCriterioVO.setNumero(numero);

            if (engdDAO.delete(engdCriterioVO) == 0) {
                throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdCriterioVO);
            }

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
     * @param numero
     *            the numero
     * @return the entidad grupo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final EntidadGrupoDatoVO select(final Long entiId, final Integer numero) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(numero);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiId);
            engdCriterioVO.setNumero(numero);

            final EntidadGrupoDatoVO engdVO = engdDAO.selectCriterio(engdCriterioVO);

            if (engdVO == null) {
                throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdCriterioVO);
            }

            return engdVO;
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param entiId
     *            the enti id
     * @return the list
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final List<EntidadGrupoDatoVO> selectList(final Long entiId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiId);

            return engdDAO.selectList(engdCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select label values.
     *
     * @param entiId
     *            the enti id
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues(final Long entiId) {
        Preconditions.checkNotNull(entiId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

        try {
            final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

            engdCriterioVO.setEntiId(entiId);

            return engdDAO.selectLabelValues(engdCriterioVO);
        } finally {
            session.close();
        }
    }
}
