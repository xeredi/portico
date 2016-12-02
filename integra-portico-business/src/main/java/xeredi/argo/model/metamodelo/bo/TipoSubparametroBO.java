package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

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
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoSubparametroVO tpsp : selectList(new TipoSubparametroCriterioVO())) {
            list.add(new LabelValueVO(tpsp.getNombre(), tpsp.getId()));
        }

        return list;
    }

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the list
     */
    public List<TipoSubparametroVO> selectList(@NonNull final TipoSubparametroCriterioVO tpspCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            return tpspDAO.selectList(tpspCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpspCriterio
     *            the tpsp criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoSubparametroVO> selectList(@NonNull final TipoSubparametroCriterioVO tpspCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final int count = tpspDAO.count(tpspCriterio);

            return new PaginatedList<>(
                    count > offset ? tpspDAO.selectList(tpspCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
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
    public TipoSubparametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final TipoSubparametroCriterioVO entiCriterio = new TipoSubparametroCriterioVO();

            entiCriterio.setId(id);
            entiCriterio.setIdioma(idioma);

            final TipoSubparametroVO enti = tpspDAO.selectObject(entiCriterio);

            if (enti == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, id);
            }

            return enti;
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
    public void insert(@NonNull final TipoSubparametroVO enti, @NonNull final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(enti.getTpprId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

            if (entiDAO.exists(enti)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpsp, enti);
            }

            IgUtilBO.assignNextVal(enti);
            enti.setTipo(TipoEntidad.B);

            entiDAO.insert(enti);
            tpspDAO.insert(enti);

            final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);
            final EntidadEntidadVO enen = new EntidadEntidadVO();

            enen.setEntiPadreId(enti.getTpprId());
            enen.setEntiHija(enti);
            enen.setOrden(0); // FIXME Corregir

            enenDAO.insert(enen);

            I18nUtilBO.insertMap(session, enti, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpsp
     *            the tpsp
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TipoSubparametroVO tpsp, @NonNull final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpsp.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);
            final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

            if (tpspDAO.update(tpsp) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpsp, tpsp);
            }

            entiDAO.update(tpsp);
            I18nUtilBO.updateMap(session, tpsp, i18nMap);

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
    public void delete(@NonNull final TipoSubparametroVO enti) throws InstanceNotFoundException {
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
            I18nUtilBO.deleteMap(session, enti);

            session.commit();
        }
    }
}
