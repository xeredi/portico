package xeredi.integra.model.metamodelo.bo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.EntidadAccionGridDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridBO.
 */
public final class EntidadAccionGridBO {

    /**
     * Insert.
     *
     * @param enag
     *            the enag
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final EntidadAccionGridVO enag, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(enag.getEntiId());
        Preconditions.checkNotNull(enag.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);
            final IgBO igBO = new IgBO();

            if (enagDAO.exists(enag)) {
                throw new DuplicateInstanceException(MessageI18nKey.enag, enag);
            }

            enag.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            enagDAO.insert(enag);
            I18nBO.insertMap(session, I18nPrefix.enag, enag.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param enag
     *            the enag
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final EntidadAccionGridVO enag, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(enag.getEntiId());
        Preconditions.checkNotNull(enag.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);
            final int updated = enagDAO.update(enag);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enag, enag);
            }

            I18nBO.updateMap(session, I18nPrefix.enag, enag.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final Long id) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);

            if (enagDAO.delete(id) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enag, id);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the entidad accion grid vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EntidadAccionGridVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);
            final EntidadAccionGridCriterioVO enagCriterio = new EntidadAccionGridCriterioVO();

            enagCriterio.setId(id);
            enagCriterio.setIdioma(idioma);

            final EntidadAccionGridVO enag = enagDAO.selectObject(enagCriterio);

            if (enag == null) {
                throw new InstanceNotFoundException(MessageI18nKey.enag, enagCriterio);
            }

            return enag;
        }
    }

    /**
     * Select list.
     *
     * @param enagCriterio
     *            the enag criterio
     * @return the list
     */
    public List<EntidadAccionGridVO> selectList(final EntidadAccionGridCriterioVO enagCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionGridDAO enagDAO = session.getMapper(EntidadAccionGridDAO.class);

            return enagDAO.selectList(enagCriterio);
        }
    }

}
