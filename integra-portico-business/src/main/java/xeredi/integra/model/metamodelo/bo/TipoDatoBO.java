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

import xeredi.integra.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.integra.model.metamodelo.dao.TipoDatoDAO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAdminBO.
 */
public class TipoDatoBO {

    /** The tpdt dao. */
    TipoDatoDAO tpdtDAO;

    /** The cdrf dao. */
    CodigoReferenciaDAO cdrfDAO;

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo dato vo
     */
    public final TipoDatoVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);
        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            final TipoDatoVO tpdtVO = tpdtDAO.select(id);

            if (tpdtVO == null) {
                throw new Error("Tipo de dato no encontrado: " + id);
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
        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public final void insert(final TipoDatoVO tpdtVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpdtVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            if (tpdtDAO.exists(tpdtVO)) {
                throw new DuplicateInstanceException(TipoDatoVO.class.getName(), tpdtVO);
            }

            tpdtVO.setId(tpdtDAO.nextSequence());
            tpdtDAO.insert(tpdtVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param tpdtVO
     *            the tpdt vo
     */
    public final void update(final TipoDatoVO tpdtVO) {
        Preconditions.checkNotNull(tpdtVO);
        Preconditions.checkNotNull(tpdtVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            tpdtDAO.update(tpdtVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param tpdtVO
     *            the tpdt vo
     */
    public void delete(final TipoDatoVO tpdtVO) {
        Preconditions.checkNotNull(tpdtVO);
        Preconditions.checkNotNull(tpdtVO.getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            tpdtDAO.delete(tpdtVO.getId());

            session.commit();
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            return tpdtDAO.selectList(tpdtCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            final int count = tpdtDAO.count(tpdtCriterioVO);
            final List<TipoDatoVO> tpdtList = new ArrayList<>();

            if (count > offset) {
                tpdtList.addAll(tpdtDAO.selectList(tpdtCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(tpdtList, offset, limit, count);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);

        try {
            return tpdtDAO.selectLabelValues(tpdtCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        tpdtDAO = session.getMapper(TipoDatoDAO.class);
        cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

        try {
            final Map<Long, TipoDatoVO> tpdtMap = tpdtDAO.selectMap(tpdtCriterioVO);
            final List<CodigoReferenciaVO> cdrfList = cdrfDAO.selectList(new CodigoReferenciaCriterioVO());
            final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

            for (final CodigoReferenciaVO cdrfVO : cdrfList) {
                if (!cdrfMap.containsKey(cdrfVO.getTpdtId())) {
                    cdrfMap.put(cdrfVO.getTpdtId(), new ArrayList<CodigoReferenciaVO>());
                }

                cdrfMap.get(cdrfVO.getTpdtId()).add(cdrfVO);
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
        } finally {
            session.close();
        }
    }

}
