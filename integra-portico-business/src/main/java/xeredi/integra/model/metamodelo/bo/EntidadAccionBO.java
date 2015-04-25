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
import xeredi.integra.model.metamodelo.dao.EntidadAccionDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionBO.
 */
public final class EntidadAccionBO {

    /**
     * Insert.
     *
     * @param enacVO
     *            the enac vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final EntidadAccionVO enacVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(enacVO.getEntiId());
        Preconditions.checkNotNull(enacVO.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);
            final IgBO igBO = new IgBO();

            if (enacDAO.exists(enacVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.enac, enacVO);
            }

            enacVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            enacDAO.insert(enacVO);
            I18nBO.insertMap(session, I18nPrefix.enac, enacVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param enacVO
     *            the enac vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final EntidadAccionVO enacVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(enacVO.getEntiId());
        Preconditions.checkNotNull(enacVO.getPath());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);
            final int updated = enacDAO.update(enacVO);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enac, enacVO);
            }

            I18nBO.updateMap(session, I18nPrefix.enac, enacVO.getId(), i18nMap);

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
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);

            if (enacDAO.delete(id) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.enac, id);
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
     * @return the entidad accion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public EntidadAccionVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);
            final EntidadAccionCriterioVO enacCriterioVO = new EntidadAccionCriterioVO();

            enacCriterioVO.setId(id);
            enacCriterioVO.setIdioma(idioma);

            final EntidadAccionVO enacVO = enacDAO.selectObject(enacCriterioVO);

            if (enacVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.enac, enacCriterioVO);
            }

            return enacVO;
        }
    }

    /**
     * Select list.
     *
     * @param enacCriterio
     *            the enac criterio
     * @return the list
     */
    public List<EntidadAccionVO> selectList(final EntidadAccionCriterioVO enacCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadAccionDAO enacDAO = session.getMapper(EntidadAccionDAO.class);

            return enacDAO.selectList(enacCriterio);
        }
    }
}
