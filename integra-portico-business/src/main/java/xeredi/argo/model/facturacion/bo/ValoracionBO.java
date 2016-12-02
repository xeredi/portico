package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public final class ValoracionBO {
    /**
     * Insert.
     *
     * @param vlrc
     *            the vlrc
     */
    public void insert(@NonNull final ValoracionVO vlrc) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            IgUtilBO.assignNextVal(vlrc);

            vlrcDAO.insert(vlrc);
            vlrcDAO.updateImporte(vlrc.getId());

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vlrc
     *            the vlrc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(@NonNull final ValoracionVO vlrc) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            if (vlrcDAO.update(vlrc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, vlrc.getId());
            }

            vlrcDAO.updateImporte(vlrc.getId());

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(@NonNull final Long id) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setVlrcId(id);
            vlrdDAO.deleteList(vlrdCriterio);

            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setVlrcId(id);
            vlrlDAO.deleteList(vlrlCriterio);

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(id);
            vlrcDAO.deleteList(vlrcCriterioVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the valoracion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(id);
        vlrcCriterio.setIdioma(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, id);
            }

            return vlrc;
        }
    }

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionVO> selectList(@NonNull final ValoracionCriterioVO vlrcCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final int count = vlrcDAO.count(vlrcCriterioVO);

            return new PaginatedList<ValoracionVO>(count > offset
                    ? vlrcDAO.selectList(vlrcCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(), offset,
                    limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    public List<ValoracionVO> selectList(@NonNull final ValoracionCriterioVO vlrcCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            return vlrcDAO.selectList(vlrcCriterioVO);
        }
    }
}
