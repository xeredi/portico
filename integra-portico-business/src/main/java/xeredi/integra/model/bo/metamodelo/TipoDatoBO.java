package xeredi.integra.model.bo.metamodelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.metamodelo.CodigoReferenciaDAO;
import xeredi.integra.model.dao.metamodelo.TipoDatoDAO;
import xeredi.integra.model.vo.metamodelo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.vo.metamodelo.CodigoReferenciaVO;
import xeredi.integra.model.vo.metamodelo.TipoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAdminBO.
 */
@Singleton
public class TipoDatoBO implements TipoDato {

    /** The tpdt dao. */
    @Inject
    TipoDatoDAO tpdtDAO;

    /** The cdrf dao. */
    @Inject
    CodigoReferenciaDAO cdrfDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final TipoDatoVO select(final Long id) {
        Preconditions.checkNotNull(id);

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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final TipoDatoVO tpdtVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(tpdtVO);

        if (tpdtDAO.exists(tpdtVO)) {
            throw new DuplicateInstanceException(TipoDatoVO.class.getName(), tpdtVO);
        }

        tpdtVO.setId(tpdtDAO.nextSequence());
        tpdtDAO.insert(tpdtVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final TipoDatoVO tpdtVO) {
        Preconditions.checkNotNull(tpdtVO);

        tpdtDAO.update(tpdtVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO) {
        Preconditions.checkNotNull(tpdtCriterioVO);

        return tpdtDAO.selectList(tpdtCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(tpdtCriterioVO);

        final int count = tpdtDAO.count(tpdtCriterioVO);
        final List<TipoDatoVO> tpdtList = new ArrayList<>();

        if (count > offset) {
            tpdtList.addAll(tpdtDAO.selectList(tpdtCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(tpdtList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues() {
        return tpdtDAO.selectLabelValues(new TipoDatoCriterioVO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterioVO) {
        Preconditions.checkNotNull(tpdtCriterioVO);

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
    }

}
