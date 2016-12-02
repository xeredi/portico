package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.dao.TipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAdminBO.
 */
public final class TipoDatoBO {
    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the tipo dato vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public TipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

            tpdtCriterio.setId(id);
            tpdtCriterio.setIdioma(idioma);

            final TipoDatoVO tpdt = tpdtDAO.selectObject(tpdtCriterio);

            if (tpdt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, id);
            }

            // Si el tipo de dato es un codigo de referencia, se buscan los
            // valores posibles
            if (tpdt.getTipoElemento() == TipoElemento.CR) {
                final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

                cdrfCriterio.setIdioma(idioma);
                cdrfCriterio.setTpdtIds(new HashSet<>(Arrays.asList(new Long[] { tpdt.getId() })));

                tpdt.setCdrfList(cdrfDAO.selectList(cdrfCriterio));

                final Set<String> cdrfCodeSet = new HashSet<>();

                for (final CodigoReferenciaVO cdrf : tpdt.getCdrfList()) {
                    cdrfCodeSet.add(cdrf.getValor());
                }

                tpdt.setCdrfCodeSet(cdrfCodeSet);
            }

            return tpdt;
        }
    }

    /**
     * Insert.
     *
     * @param tpdt
     *            the tpdt
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            if (tpdtDAO.exists(tpdt)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpdt, tpdt);
            }

            IgUtilBO.assignNextVal(tpdt);
            tpdtDAO.insert(tpdt);

            I18nUtilBO.insertMap(session, tpdt, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpdt
     *            the tpdt
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            if (tpdtDAO.update(tpdt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt.getCodigo());
            }

            I18nUtilBO.updateMap(session, tpdt, i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param tpdt
     *            the tpdt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final TipoDatoVO tpdt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nUtilBO.deleteMap(session, tpdt);

            final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

            cdrfCriterio.setTpdtId(tpdt.getId());

            cdrfDAO.deleteList(cdrfCriterio);

            if (tpdtDAO.delete(tpdt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt);
            }

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the list
     */
    public List<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            return tpdtDAO.selectList(tpdtCriterio);
        }
    }

    /**
     * Select list.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final int count = tpdtDAO.count(tpdtCriterio);

            return new PaginatedList<>(
                    count > offset ? tpdtDAO.selectList(tpdtCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
        }
    }

    /**
     * Select label values.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
        final List<LabelValueVO> list = new ArrayList<>();

        for (final TipoDatoVO tpdt : selectList(tpdtCriterio)) {
            list.add(new LabelValueVO(tpdt.getNombre(), tpdt.getId()));
        }

        return list;
    }

    /**
     * Select map.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the map
     */
    public Map<Long, TipoDatoVO> selectMap(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            final Map<Long, TipoDatoVO> tpdtMap = tpdtDAO.selectMap(tpdtCriterio);
            final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

            for (final CodigoReferenciaVO cdrf : cdrfDAO.selectList(new CodigoReferenciaCriterioVO())) {
                if (!cdrfMap.containsKey(cdrf.getTpdtId())) {
                    cdrfMap.put(cdrf.getTpdtId(), new ArrayList<CodigoReferenciaVO>());
                }

                cdrfMap.get(cdrf.getTpdtId()).add(cdrf);

                cdrf.setTpdtId(null);
                cdrf.setOrden(null);
            }

            for (final TipoDatoVO tpdt : tpdtMap.values()) {
                if (cdrfMap.containsKey(tpdt.getId())) {
                    tpdt.setCdrfList(cdrfMap.get(tpdt.getId()));

                    final Set<String> cdrfCodeSet = new HashSet<>();

                    for (final CodigoReferenciaVO cdrf : cdrfMap.get(tpdt.getId())) {
                        cdrfCodeSet.add(cdrf.getValor());
                    }

                    tpdt.setCdrfCodeSet(cdrfCodeSet);
                }

                tpdtMap.put(tpdt.getId(), tpdt);
            }

            return tpdtMap;
        }
    }
}
