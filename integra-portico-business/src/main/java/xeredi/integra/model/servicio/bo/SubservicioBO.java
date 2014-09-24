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
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioBO.
 */
public class SubservicioBO {

    /** The ssrv dao. */
    SubservicioDAO ssrvDAO;

    /** The ssdt dao. */
    SubservicioDatoDAO ssdtDAO;

    /** The ssss dao. */
    SubservicioSubservicioDAO ssssDAO;

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);

        try {
            final int count = ssrvDAO.selectCount(ssrvCriterioVO);
            final List<SubservicioVO> ssrvList = new ArrayList<>();

            if (count > offset) {
                ssrvCriterioVO.setOffset(offset);
                ssrvCriterioVO.setLimit(limit);

                ssrvList.addAll(ssrvDAO.selectList(ssrvCriterioVO));

                ssrvCriterioVO.setOffset(null);
                ssrvCriterioVO.setLimit(null);

                fillDependencies(session, ssrvList, ssrvCriterioVO);
            }

            return new PaginatedList<>(ssrvList, offset, limit, count);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);

        try {
            final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);

            fillDependencies(session, ssrvList, ssrvCriterioVO);

            return ssrvList;
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);

        try {
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setIdioma(idioma);

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            fillDependencies(session, Arrays.asList(new SubservicioVO[] { ssrvVO }), ssrvCriterioVO);

            return ssrvVO;
        } finally {
            session.close();
        }
    }

    /**
     * Select lupa list.
     *
     * @param ssrvLupaCriterioVO
     *            the ssrv lupa criterio vo
     * @return the list
     */
    public final List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvLupaCriterioVO) {
        Preconditions.checkNotNull(ssrvLupaCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);

        try {
            return ssrvDAO.selectLupaList(ssrvLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET,
                    GlobalNames.LUPA_LIMIT_DEFAULT));
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);
        ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
        ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

        try {
            if (tpssVO.getEntdList() != null && !tpssVO.getEntdList().isEmpty()) {
                for (final Long tpdtId : tpssVO.getEntdList()) {
                    if (!ssrvVO.getItdtMap().containsKey(tpdtId) && !ssrvVO.getItdtMap().containsKey(tpdtId.toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        ssrvVO.getItdtMap().put(tpdtId, itdt);
                    }
                }
            }

            final IgBO igBO = new IgBO();

            if (ssrvDAO.exists(ssrvVO)) {
                throw new DuplicateInstanceException(SubservicioVO.class.getName(), ssrvVO);
            }

            ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

        try {
            for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(Long.valueOf(tpdtId));

                if (ssdtDAO.update(itdtVO) == 0) {
                    throw new Error("Error modificando un subservicio de dato no existente: " + itdtVO);
                }
            }

            session.commit();
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        try {
            throw new Error("No Implementado");
        } finally {
            session.close();
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
            final SubservicioCriterioVO ssrvCriterioVO) {
        Preconditions.checkNotNull(ssrvList);
        Preconditions.checkNotNull(ssrvCriterioVO);

        ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

        // Datos asociados
        if (!ssrvList.isEmpty()) {
            final Set<Long> ssrvIds = new HashSet<>();

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvIds.add(ssrvVO.getId());
            }

            ssrvCriterioVO.setIds(ssrvIds);

            final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);

            ssrvCriterioVO.setIds(null);

            final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

            for (final ItemDatoVO itdtVO : ssdtList) {
                if (!itdtMap.containsKey(itdtVO.getItemId())) {
                    itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final SubservicioVO ssrvVO : ssrvList) {
                ssrvVO.setItdtMap(itdtMap.get(ssrvVO.getId()));
            }
        }
    }

}
