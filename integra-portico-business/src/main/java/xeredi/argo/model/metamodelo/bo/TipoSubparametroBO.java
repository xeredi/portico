package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroBO.
 */
public final class TipoSubparametroBO {
    /**
     * Select label values.
     *
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoSubparametroVO tpsp : tpspDAO.selectList(new TipoSubparametroCriterioVO())) {
                list.add(new LabelValueVO(tpsp.getNombre(), tpsp.getId()));
            }

            return list;
        }
    }

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the list
     */
    public List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            return tpspDAO.selectList(tpspCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final int count = tpspDAO.count(tpspCriterioVO);
            final List<TipoSubparametroVO> list = new ArrayList<>();

            if (count > offset) {
                list.addAll(tpspDAO.selectList(tpspCriterioVO, new RowBounds(offset, limit)));
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
     * @return the tipo subparametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoSubparametroVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final TipoSubparametroCriterioVO entiCriterioVO = new TipoSubparametroCriterioVO();

            entiCriterioVO.setId(id);
            entiCriterioVO.setIdioma(idioma);

            final TipoSubparametroVO entiVO = tpspDAO.selectObject(entiCriterioVO);

            if (entiVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, id);
            }

            return entiVO;
        }
    }

    /**
     * Insert.
     *
     * @param enti
     *            the enti
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull TipoSubparametroVO enti, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (entiDAO.exists(enti)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpsp, enti);
            }

            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            enti.setId(entiDAO.nextSequence());
            enti.setTipo(TipoEntidad.B);

            entiDAO.insert(enti);
            tpspDAO.insert(enti);

            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final EntidadEntidadVO enen = new EntidadEntidadVO();

            enen.setEntiPadreId(enti.getTpprId());
            enen.setEntiHija(enti);
            enen.setOrden(0); // FIXME Corregir

            enenDAO.insert(enen);

            I18nBO.insertMap(session, ClassPrefix.enti, enti.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpspVO
     *            the tpsp vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull TipoSubparametroVO tpspVO, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpspVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpspDAO.update(tpspVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, tpspVO);
            }

            entiDAO.update(tpspVO);
            I18nBO.updateMap(session, ClassPrefix.enti, tpspVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param enti
     *            the enti
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull TipoSubparametroVO enti) throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti.getId());
        Preconditions.checkNotNull(enti.getTpprId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);

            if (tpspDAO.delete(enti) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, enti);
            }

            final EntidadEntidadVO enen = new EntidadEntidadVO();

            enen.setEntiPadreId(enti.getTpprId());
            enen.setEntiHija(enti);

            enenDAO.delete(enen);
            entiDAO.delete(enti);
            I18nBO.deleteMap(session, ClassPrefix.enti, enti.getId());

            session.commit();
        }
    }
}
