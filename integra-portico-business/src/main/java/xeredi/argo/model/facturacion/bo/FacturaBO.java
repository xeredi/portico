package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaImpresionVO;
import xeredi.argo.model.facturacion.vo.FacturaTypeaheadCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
public final class FacturaBO {

    /**
     * Select imprimir.
     *
     * @param fctrIds
     *            the fctr ids
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<FacturaImpresionVO> selectImprimir(@NonNull final Set<Long> fctrIds, final String idioma) {
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
    public FacturaVO select(@NonNull final Long fctrId, final String idioma) throws InstanceNotFoundException {
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
    public PaginatedList<FacturaVO> selectList(@NonNull final FacturaCriterioVO fctrCriterio, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final int count = fctrDAO.count(fctrCriterio);

            return new PaginatedList<FacturaVO>(
                    count > offset ? fctrDAO.selectList(fctrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
                    offset, limit, count);
        }
    }

    /**
     * Select typeahead list.
     *
     * @param criterio
     *            the criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<FacturaVO> selectTypeaheadList(@NonNull final FacturaTypeaheadCriterioVO criterio, final int limit) {
        Preconditions.checkNotNull(criterio.getTextoBusqueda());

        final StringTokenizer tokenizer = new StringTokenizer(criterio.getTextoBusqueda(), "/");

        criterio.setSerie(tokenizer.nextToken().toUpperCase() + "%");

        if (tokenizer.hasMoreTokens()) {
            criterio.setAnio(tokenizer.nextToken() + "%");
        }

        if (tokenizer.hasMoreTokens()) {
            criterio.setNumero(tokenizer.nextToken() + "%");
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);

            return fctrDAO.selectTypeaheadList(criterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }
}
