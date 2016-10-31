package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoCargoDAO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoBO.
 */
public final class AspectoCargoBO {
    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<AspectoCargoVO> selectList(final @NonNull AspectoCargoCriterioVO criterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            return ascrDAO.selectList(criterioVO);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param fref
     *            the fref
     * @param idioma
     *            the idioma
     * @return the aspecto cargo VO
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AspectoCargoVO select(final @NonNull Long id, final @NonNull Date fref, final String idioma)
            throws InstanceNotFoundException {
        final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

        ascrCriterio.setId(id);
        ascrCriterio.setFechaVigencia(fref);
        ascrCriterio.setIdioma(idioma);

        return selectObject(ascrCriterio);
    }

    /**
     * Select.
     *
     * @param ascrCriterio
     *            the ascr criterio
     * @return the aspecto cargo vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AspectoCargoVO selectObject(final @NonNull AspectoCargoCriterioVO ascrCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);
            final AspectoCargoVO ascr = ascrDAO.selectObject(ascrCriterio);

            if (ascr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, ascrCriterio);
            }

            return ascr;
        }
    }

    /**
     * Insert.
     *
     * @param ascr
     *            the ascr
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final @NonNull AspectoCargoVO ascr) throws OverlapException {
        Preconditions.checkNotNull(ascr.getVersion());
        Preconditions.checkNotNull(ascr.getVersion().getFini());
        Preconditions.checkNotNull(ascr.getAspcId());
        Preconditions.checkNotNull(ascr.getCrgo());
        Preconditions.checkNotNull(ascr.getCrgo().getId());

        DateUtil.truncTime(ascr.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(ascr.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            final IgBO igBO = new IgBO();

            if (ascrDAO.exists(ascr)) {
                ascr.setId(ascrDAO.selectId(ascr));

                if (ascrDAO.existsOverlap(ascr)) {
                    throw new OverlapException(MessageI18nKey.ascr, ascr);
                }
            } else {
                igBO.assignNextVal(ascr);

                ascrDAO.insert(ascr);
            }

            igBO.assignNextVal(ascr.getVersion());

            ascrDAO.insertVersion(ascr);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param ascr
     *            the ascr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final @NonNull AspectoCargoVO ascr) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(ascr.getId());
        Preconditions.checkNotNull(ascr.getVersion());
        Preconditions.checkNotNull(ascr.getVersion().getId());
        Preconditions.checkNotNull(ascr.getVersion().getFini());

        DateUtil.truncTime(ascr.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(ascr.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            if (ascrDAO.existsOverlap(ascr)) {
                throw new OverlapException(MessageI18nKey.ascr, ascr);
            }

            if (ascrDAO.updateVersion(ascr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, ascr);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param ascr
     *            the ascr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull AspectoCargoVO ascr) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascr.getVersion());
        Preconditions.checkNotNull(ascr.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            if (ascrDAO.deleteVersion(ascr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, ascr);
            }

            session.commit();
        }
    }
}
