package xeredi.integra.model.servicio.bo;

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

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioBO.
 */
public class SubservicioBO {
    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(ssrvCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final int count = ssrvDAO.selectCount(ssrvCriterioVO);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvCriterioVO.setOffset(offset);
                ssrvCriterioVO.setLimit(limit);

                ssrvList.addAll(ssrvDAO.selectPaginatedList(ssrvCriterioVO));
                fillDependencies(session, ssrvList, ssrvCriterioVO, true);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    public List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO) {
        Preconditions.checkNotNull(ssrvCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);

            fillDependencies(session, ssrvList, ssrvCriterioVO, false);

            return ssrvList;
        }
    }

    /**
     * Select.
     *
     * @param ssrvId
     *            the ssrv id
     * @param idioma
     *            the idioma
     * @return the subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public SubservicioVO select(final Long ssrvId, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setIdioma(idioma);

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvId);
            }

            fillDependencies(session, Arrays.asList(new SubservicioVO[] { ssrvVO }), ssrvCriterioVO, true);

            return ssrvVO;
        }
    }

    /**
     * Select lupa list.
     *
     * @param ssrvLupaCriterioVO
     *            the ssrv lupa criterio vo
     * @return the list
     */
    public final List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvLupaCriterioVO, final int limit) {
        Preconditions.checkNotNull(ssrvLupaCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

            return ssrvDAO.selectLupaList(ssrvLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @param tpssVO
     *            the tpss vo
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final SubservicioVO ssrvVO, final TipoSubservicioVO tpssVO, final Set<Long> ssrvPadreIds)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(ssrvVO);
        Preconditions.checkNotNull(ssrvPadreIds);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

            if (tpssVO.getEntdList() != null && !tpssVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpssVO.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!ssrvVO.getItdtMap().containsKey(tpdtId) && !ssrvVO.getItdtMap().containsKey(tpdtId.toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        ssrvVO.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            final IgBO igBO = new IgBO();

            if (ssrvDAO.exists(ssrvVO)) {
                throw new DuplicateInstanceException(ssrvVO.getEntiId(), ssrvVO);
            }

            ssrvVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            ssrvDAO.insert(ssrvVO);

            for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);
                ssdtDAO.insert(itdtVO);
            }

            for (final Long ssrvPadreId : ssrvPadreIds) {
                final SubservicioSubservicioVO ssssVO = new SubservicioSubservicioVO(ssrvPadreId, ssrvVO.getId());

                ssssDAO.insert(ssssVO);
            }

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final SubservicioVO ssrvVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                ssdtDAO.update(itdtVO);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final Long ssrvId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            throw new Error("No Implementado");
        }
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param ssrvList
     *            the ssrv list
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     */
    private void fillDependencies(final SqlSession session, final List<SubservicioVO> ssrvList,
            final SubservicioCriterioVO ssrvCriterioVO, final boolean useIds) {
        Preconditions.checkNotNull(ssrvList);
        Preconditions.checkNotNull(ssrvCriterioVO);

        final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

        // Datos asociados
        if (!ssrvList.isEmpty()) {
            if (useIds) {
                final Set<Long> ssrvIds = new HashSet<>();

                for (final SubservicioVO ssrvVO : ssrvList) {
                    ssrvIds.add(ssrvVO.getId());
                }

                ssrvCriterioVO.setIds(ssrvIds);
            }

            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : ssdtDAO.selectList(ssrvCriterioVO)) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
            }

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvVO.setItdtMap(itdtMap.get(ssrvVO.getId()));
            }

            if (useIds) {
                ssrvCriterioVO.setIds(null);
            }
        }
    }

}
