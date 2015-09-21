package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.dao.TipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

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
    public TipoDatoVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);
            final TipoDatoCriterioVO tpdtCriterioVO = new TipoDatoCriterioVO();

            tpdtCriterioVO.setId(id);
            tpdtCriterioVO.setIdioma(idioma);

            final TipoDatoVO tpdtVO = tpdtDAO.selectObject(tpdtCriterioVO);

            if (tpdtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, id);
            }

            // Si el tipo de dato es un codigo de referencia, se buscan los
            // valores posibles
            if (tpdtVO.getTipoElemento() == TipoElemento.CR) {
                final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

                cdrfCriterio.setIdioma(idioma);
                cdrfCriterio.setTpdtIds(new HashSet<>(Arrays.asList(new Long[] { tpdtVO.getId() })));

                tpdtVO.setCdrfList(cdrfDAO.selectList(cdrfCriterio));

                final Set<String> cdrfCodeSet = new HashSet<>();

                for (final CodigoReferenciaVO cdrfVO : tpdtVO.getCdrfList()) {
                    cdrfCodeSet.add(cdrfVO.getValor());
                }

                tpdtVO.setCdrfCodeSet(cdrfCodeSet);
            }

            return tpdtVO;
        }
    }

    /**
     * Insert.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final TipoDatoVO tpdtVO, final Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            if (tpdtDAO.exists(tpdtVO)) {
                throw new DuplicateInstanceException(MessageI18nKey.tpdt, tpdtVO);
            }

            tpdtVO.setId(tpdtDAO.nextSequence());
            tpdtDAO.insert(tpdtVO);

            I18nBO.insertMap(session, I18nPrefix.tpdt, tpdtVO.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final TipoDatoVO tpdtVO, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdtVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            if (tpdtDAO.update(tpdtVO) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdtVO.getCodigo());
            }

            I18nBO.updateMap(session, I18nPrefix.tpdt, tpdtVO.getId(), i18nMap);

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
    public void delete(final @NonNull TipoDatoVO tpdt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.tpdt, tpdt.getId());

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
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the list
     */
    public List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

            return tpdtDAO.selectList(tpdtCriterioVO);
        }
    }

    /**
     * Select list.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final int count = tpdtDAO.count(tpdtCriterioVO);
            final List<TipoDatoVO> tpdtList = new ArrayList<>();

            if (count > offset) {
                tpdtList.addAll(tpdtDAO.selectList(tpdtCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(tpdtList, offset, limit, count);
        }
    }

    /**
     * Select label values.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValues(final TipoDatoCriterioVO tpdtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final TipoDatoVO tpdt : tpdtDAO.selectList(tpdtCriterioVO)) {
                list.add(new LabelValueVO(tpdt.getNombre(), tpdt.getId()));
            }

            return list;
        }
    }

    /**
     * Select map.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the map
     */
    public Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            final Map<Long, TipoDatoVO> tpdtMap = tpdtDAO.selectMap(tpdtCriterioVO);
            final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

            for (final CodigoReferenciaVO cdrfVO : cdrfDAO.selectList(new CodigoReferenciaCriterioVO())) {
                if (!cdrfMap.containsKey(cdrfVO.getTpdtId())) {
                    cdrfMap.put(cdrfVO.getTpdtId(), new ArrayList<CodigoReferenciaVO>());
                }

                cdrfMap.get(cdrfVO.getTpdtId()).add(cdrfVO);

                cdrfVO.setTpdtId(null);
                cdrfVO.setOrden(null);
            }

            for (final TipoDatoVO tpdtVO : tpdtMap.values()) {
                if (cdrfMap.containsKey(tpdtVO.getId())) {
                    tpdtVO.setCdrfList(cdrfMap.get(tpdtVO.getId()));

                    final Set<String> cdrfCodeSet = new HashSet<>();

                    for (final CodigoReferenciaVO cdrfVO : cdrfMap.get(tpdtVO.getId())) {
                        cdrfCodeSet.add(cdrfVO.getValor());
                    }

                    tpdtVO.setCdrfCodeSet(cdrfCodeSet);
                }

                tpdtMap.put(tpdtVO.getId(), tpdtVO);
            }

            return tpdtMap;
        }
    }
}
