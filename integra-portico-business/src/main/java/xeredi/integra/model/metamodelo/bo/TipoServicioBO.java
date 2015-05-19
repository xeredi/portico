package xeredi.integra.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.EntidadDAO;
import xeredi.integra.model.metamodelo.dao.TipoServicioDAO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAdminBO.
 */
public final class TipoServicioBO {
    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final TipoServicioCriterioVO criterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoServicioVO tpsr : tpsrDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
            }

            return list;
        }
    }

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the list
     */
    public List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);

            return tpsrDAO.selectList(tpsrCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final int count = tpsrDAO.count(tpsrCriterioVO);
            final List<TipoServicioVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpsrDAO.selectList(tpsrCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoServicioVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final TipoServicioCriterioVO entiCriterioVO = new TipoServicioCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoServicioVO entiVO = tpsrDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, id);
            }

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final TipoServicioVO tpsrVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(tpsrVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpsr, tpsrVO);
            }

            tpsrVO.setId(entiDAO.nextSequence());
            tpsrVO.setTipo(TipoEntidad.T);

            entiDAO.insert(tpsrVO);
            tpsrDAO.insert(tpsrVO);
            I18nBO.insertMap(session, I18nPrefix.enti, tpsrVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final TipoServicioVO tpsrVO, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsrVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpsrDAO.update(tpsrVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsrVO);
            }

            entiDAO.update(tpsrVO);
            I18nBO.updateMap(session, I18nPrefix.enti, tpsrVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpsr
     *            the tpsr
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final TipoServicioVO tpsr) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpsrDAO.delete(tpsr) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
            }

            I18nBO.deleteMap(session, I18nPrefix.enti, tpsr.getId());
            entiDAO.delete(tpsr);

            session.commit();
        }
    }
}
