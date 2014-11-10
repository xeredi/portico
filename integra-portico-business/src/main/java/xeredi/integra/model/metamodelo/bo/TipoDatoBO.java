package xeredi.integra.model.metamodelo.bo;

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

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.integra.model.metamodelo.dao.TipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAdminBO.
 */
public class TipoDatoBO {
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
    public final TipoDatoVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(idioma);

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
                final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

                cdrfCriterioVO.setTpdtIds(new HashSet<>(Arrays.asList(new Long[] { tpdtVO.getId() })));

                final List<CodigoReferenciaVO> cdrfList = cdrfDAO.selectList(cdrfCriterioVO);
                final Set<String> cdrfCodeSet = new HashSet<>();

                for (final CodigoReferenciaVO cdrfVO : cdrfList) {
                    cdrfCodeSet.add(cdrfVO.getValor());
                }

                tpdtVO.setCdrfList(cdrfList);
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
    public final void insert(final TipoDatoVO tpdtVO, final Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpdtVO);

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
    public final void update(final TipoDatoVO tpdtVO, final Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdtVO);
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
     * @param tpdtVO
     *            the tpdt vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final TipoDatoVO tpdtVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(tpdtVO);
        Preconditions.checkNotNull(tpdtVO.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.tpdt, tpdtVO.getId());

            cdrfDAO.deleteList(tpdtVO.getId());

            if (tpdtDAO.delete(tpdtVO.getId()) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdtVO.getId());
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
    public final List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO) {
        Preconditions.checkNotNull(tpdtCriterioVO);

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
    public final PaginatedList<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(tpdtCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
            final int count = tpdtDAO.count(tpdtCriterioVO);
            final List<TipoDatoVO> tpdtList = new ArrayList<>();

            if (count > offset) {
                tpdtList.addAll(tpdtDAO.selectPaginatedList(tpdtCriterioVO, new RowBounds(offset, limit)));
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
    public final List<LabelValueVO> selectLabelValues(final TipoDatoCriterioVO tpdtCriterioVO) {
        Preconditions.checkNotNull(tpdtCriterioVO);

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
    public final Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterioVO) {
        Preconditions.checkNotNull(tpdtCriterioVO);

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
