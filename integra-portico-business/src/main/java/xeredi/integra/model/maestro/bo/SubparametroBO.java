package xeredi.integra.model.maestro.bo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.dao.SubparametroDAO;
import xeredi.integra.model.maestro.dao.SubparametroDatoDAO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroBO.
 */
public class SubparametroBO {

    /** The sprm dao. */
    SubparametroDAO sprmDAO;

    /** The spdt dao. */
    SubparametroDatoDAO spdtDAO;

    /**
     * Insert.
     *
     * @param sprm
     *            the sprm
     * @param tpspVO
     *            the tpsp vo
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final SubparametroVO sprm, final TipoSubparametroVO tpspVO) throws OverlapException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(tpspVO);

        // Validar que los datos del subparametro son correctos
        if (tpspVO.getEntdList() != null && !tpspVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpspVO.getEntdList()) {
                if (!sprm.getItdtMap().containsKey(String.valueOf(tpdtId))) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    sprm.getItdtMap().put(tpdtId, itdt);
                }
            }
        }

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);
        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (sprmDAO.exists(sprm)) {
                sprm.setId(sprmDAO.selectId(sprm));
            } else {
                sprm.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                sprmDAO.insert(sprm);
            }

            sprm.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            if (sprmDAO.existsOverlap(sprm)) {
                throw new OverlapException(SubparametroVO.class.getName(), sprm);
            }

            sprmDAO.insertVersion(sprm);

            if (sprm.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                    itdtVO.setItemId(sprm.getSpvr().getId());
                    spdtDAO.insert(itdtVO);
                }
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Duplicate.
     *
     * @param sprm
     *            the sprm
     * @param tpsrVO
     *            the tpsr vo
     * @throws OverlapException
     *             the overlap exception
     */
    public void duplicate(final SubparametroVO sprm, final TipoSubparametroVO tpsrVO) throws OverlapException {
        // TODO Implementar
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getId());
        Preconditions.checkNotNull(tpsrVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);
        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (sprmDAO.exists(sprm)) {
                sprm.setId(sprmDAO.selectId(sprm));
            } else {
                sprm.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                sprmDAO.insert(sprm);
            }

            sprm.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            if (sprmDAO.existsOverlap(sprm)) {
                throw new OverlapException(SubparametroVO.class.getName(), sprm);
            }

            sprmDAO.insertVersion(sprm);

            if (sprm.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                    itdtVO.setItemId(sprm.getSpvr().getId());
                    spdtDAO.insert(itdtVO);
                }
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param sprm
     *            the sprm
     * @param tpspVO
     *            the tpsp vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public final void update(final SubparametroVO sprm, final TipoSubparametroVO tpspVO)
            throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(tpspVO);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(sprm.getSpvr().getId());
        Preconditions.checkNotNull(sprm.getSpvr().getFini());

        // Validaciones

        // Validar que los datos del parametro son correctos
        if (!tpspVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpspVO.getEntdList()) {
                if (!sprm.getItdtMap().containsKey(tpdtId.toString())) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    sprm.getItdtMap().put(tpdtId, itdt);

                    // throw new Error("No se ha pasado informacion del dato "
                    // + tpspVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del subparametro: " + sprm);
                }
            }
        }

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);
        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try {
            if (sprmDAO.existsOverlap(sprm)) {
                throw new OverlapException(SubparametroVO.class.getName(), sprm);
            }

            final int updated = sprmDAO.updateVersion(sprm);

            if (updated == 0) {
                throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprm);
            }

            if (sprm.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                    itdtVO.setItemId(sprm.getSpvr().getId());
                    spdtDAO.update(itdtVO);
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
     * @param sprm
     *            the sprm
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final SubparametroVO sprm) throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprm);
        Preconditions.checkNotNull(sprm.getSpvr());
        Preconditions.checkNotNull(sprm.getSpvr().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);
        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try {
            spdtDAO.deleteVersion(sprm);

            final int updated = sprmDAO.deleteVersion(sprm);

            if (updated == 0) {
                throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprm);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(sprmCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);

        try {
            List<SubparametroVO> sprmList = null;

            final int count = sprmDAO.selectCount(sprmCriterioVO);

            if (count > offset) {
                sprmList = sprmDAO.selectList(sprmCriterioVO, new RowBounds(offset, limit));

                // FIXME Ojo en la paginacion, puede traer una barbaridad de
                // dependencias
                fillDependencies(session, sprmList, sprmCriterioVO);
            }

            return new PaginatedList<>(sprmList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    public final List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO) {
        Preconditions.checkNotNull(sprmCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);

        try {
            final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);

            if (!sprmList.isEmpty()) {
                fillDependencies(session, sprmList, sprmCriterioVO);
            }

            return sprmList;
        } finally {
            session.close();
        }
    }

    /**
     * Select object.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the subparametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final SubparametroVO selectObject(final SubparametroCriterioVO sprmCriterioVO)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprmCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        sprmDAO = session.getMapper(SubparametroDAO.class);

        try {
            final SubparametroVO sprmVO = sprmDAO.selectObject(sprmCriterioVO);

            if (sprmVO == null) {
                throw new InstanceNotFoundException(SubparametroVO.class.getName(), sprmCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new SubparametroVO[] { sprmVO }), sprmCriterioVO);

            return sprmVO;
        } finally {
            session.close();
        }
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param sprmList
     *            the sprm list
     * @param sprmCriterioVO
     *            the sprm criterio vo
     */
    private void fillDependencies(final SqlSession session, final Collection<SubparametroVO> sprmList,
            final SubparametroCriterioVO sprmCriterioVO) {
        Preconditions.checkNotNull(sprmList);
        Preconditions.checkNotNull(sprmCriterioVO);

        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        if (!sprmList.isEmpty()) {
            final Set<Long> spvrIds = new HashSet<>();

            for (final SubparametroVO sprmVO : sprmList) {
                spvrIds.add(sprmVO.getSpvr().getId());
            }

            sprmCriterioVO.setSpvrIds(spvrIds);

            final List<ItemDatoVO> itdtList = spdtDAO.selectList(sprmCriterioVO);
            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : itdtList) {
                if (!map.containsKey(itdtVO.getItemId())) {
                    map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final SubparametroVO sprmVO : sprmList) {
                sprmVO.setItdtMap(map.get(sprmVO.getSpvr().getId()));
            }

            sprmCriterioVO.setSpvrIds(null);
        }
    }

}
