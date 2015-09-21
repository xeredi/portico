package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.CargoDAO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoBO.
 */
public class CargoBO {

    /**
     * Select list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<CargoVO> selectList(final CargoCriterioVO crgoCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(crgoCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final int count = crgoDAO.count(crgoCriterioVO);
            final List<CargoVO> crgoList = new ArrayList<>();

            if (count >= offset) {
                crgoList.addAll(crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<CargoVO>(crgoList, offset, limit, count);
        }
    }

    /**
     * Select label value list.
     *
     * @param crgoCriterio
     *            the crgo criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<CargoVO> selectList(final CargoCriterioVO crgoCriterio, final int limit) {
        Preconditions.checkNotNull(crgoCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            return crgoDAO.selectList(crgoCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }

    /**
     * Select label value list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @return the list
     */
    public List<CargoVO> selectList(final CargoCriterioVO crgoCriterioVO) {
        Preconditions.checkNotNull(crgoCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            return crgoDAO.selectList(crgoCriterioVO);
        }
    }

    /**
     * Select.
     *
     * @param crgoCriterio the crgo criterio
     * @return the cargo vo
     * @throws InstanceNotFoundException             the instance not found exception
     */
    public CargoVO selectObject(final CargoCriterioVO crgoCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final CargoVO crgo = crgoDAO.selectObject(crgoCriterio);

            if (crgo == null) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgoCriterio);
            }

            return crgo;
        }
    }

    /**
     * Insert.
     *
     * @param crgo
     *            the crgo
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final CargoVO crgo, final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getFini());
        Preconditions.checkNotNull(crgo.getTpsr());
        Preconditions.checkNotNull(crgo.getTpsr().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);
            final IgBO igBO = new IgBO();

            if (crgoDAO.exists(crgo)) {
                crgo.setId(crgoDAO.selectId(crgo));

                if (crgoDAO.existsOverlap(crgo)) {
                    throw new OverlapException(MessageI18nKey.crgo, crgo);
                }
            } else {
                crgo.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                crgoDAO.insert(crgo);
            }

            crgo.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            crgoDAO.insertVersion(crgo);

            I18nBO.insertMap(session, I18nPrefix.crgv, crgo.getVersion().getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param crgo
     *            the crgo
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final CargoVO crgo, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException,
            OverlapException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            if (crgoDAO.existsOverlap(crgo)) {
                throw new OverlapException(MessageI18nKey.crgo, crgo);
            }

            final int updated = crgoDAO.updateVersion(crgo);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
            }

            I18nBO.updateMap(session, I18nPrefix.crgv, crgo.getVersion().getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param crgo the crgo
     * @throws InstanceNotFoundException             the instance not found exception
     */
    public void delete(final CargoVO crgo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getVersion());
        Preconditions.checkNotNull(crgo.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final CargoDAO crgoDAO = session.getMapper(CargoDAO.class);

            if (crgoDAO.deleteVersion(crgo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
            }

            I18nBO.deleteMap(session, I18nPrefix.crgv, crgo.getVersion().getId());

            session.commit();
        }
    }

}
