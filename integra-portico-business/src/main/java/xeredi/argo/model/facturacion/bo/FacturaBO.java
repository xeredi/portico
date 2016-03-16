package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
public class FacturaBO {

    /**
     * Select imprimir.
     *
     * @param fctrIds
     *            the fctr ids
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<FacturaImpresionVO> selectImprimir(final @NonNull Set<Long> fctrIds, final String idioma) {
        Preconditions.checkArgument(!fctrIds.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final List<FacturaImpresionVO> list = new ArrayList<>();

            for (final Long fctrId : fctrIds) {
                final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
                final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

                fctrCriterio.setId(fctrId);
                fctrCriterio.setIdioma(idioma);

                final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

                if (fctr != null) {
                    final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

                    vlrcCriterio.setFctr(fctr);
                    vlrcCriterio.setIdioma(idioma);

                    final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
                    final List<ValoracionCargoVO> vlrgList = vlrgDAO.selectList(vlrcCriterio);

                    final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
                    final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectList(vlrcCriterio);

                    final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                    vlrlCriterio.setFctrId(fctr.getId());

                    final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
                    final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterio);

                    final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
                    final Map<Long, ValoracionVO> vlrcMap = new HashMap<>();

                    for (final ValoracionVO vlrc : vlrcDAO.selectList(vlrcCriterio)) {
                        vlrcMap.put(vlrc.getId(), vlrc);
                    }

                    list.add(new FacturaImpresionVO(fctr, vlrgList, vlriList, vlrlList, vlrcMap));
                }
            }

            return list;
        }
    }

    /**
     * Select.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @return the factura vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public FacturaVO select(final @NonNull Long fctrId, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);
            fctrCriterio.setIdioma(idioma);

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

            if (fctr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctr, fctrId);
            }

            return fctr;
        }
    }

    /**
     * Select list.
     *
     * @param fctrCriterio
     *            the fctr criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<FacturaVO> selectList(final @NonNull FacturaCriterioVO fctrCriterio, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final int count = fctrDAO.count(fctrCriterio);
            final List<FacturaVO> fctrList = new ArrayList<>();

            if (count >= offset) {
                fctrList.addAll(fctrDAO.selectList(fctrCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<FacturaVO>(fctrList, offset, limit, count);
        }
    }
}
