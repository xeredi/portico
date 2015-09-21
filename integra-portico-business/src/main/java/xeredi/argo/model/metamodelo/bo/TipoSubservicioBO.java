package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubservicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAdminBO.
 */
public final class TipoSubservicioBO {
    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final TipoSubservicioCriterioVO criterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoSubservicioVO tpss : tpssDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
            }

            return list;
        }
    }

    /**
     * Select list.
     *
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the list
     */
    public List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);

            return tpssDAO.selectList(tpssCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final int count = tpssDAO.count(tpssCriterioVO);
            final List<TipoSubservicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpssDAO.selectList(tpssCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(list, offset, limit, count);
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the tipo subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoSubservicioVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final TipoSubservicioCriterioVO entiCriterioVO = new TipoSubservicioCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubservicioVO entiVO = tpssDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, id);
            }

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpssVO
     *            the tpss vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final TipoSubservicioVO tpssVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpssVO.getTpsrId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tpssVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpss, tpssVO);
            }

            final Long id = entiDAO.nextSequence();

            tpssVO.setId(id);
            tpssVO.setTipo(TipoEntidad.S);

            entiDAO.insert(tpssVO);
            tpssDAO.insert(tpssVO);
            I18nBO.insertMap(session, I18nPrefix.enti, tpssVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpssVO
     *            the tpss vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final TipoSubservicioVO tpssVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpssVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpssDAO.update(tpssVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, tpssVO);
            }

            entiDAO.update(tpssVO);
            I18nBO.updateMap(session, I18nPrefix.enti, tpssVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpss
     *            the tpss
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final TipoSubservicioVO tpss) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpssDAO.delete(tpss) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpss, tpss);
            }

            entiDAO.delete(tpss);
            I18nBO.deleteMap(session, I18nPrefix.enti, tpss.getId());

            session.commit();
        }
    }
}
