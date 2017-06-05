package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

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

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaService.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class FacturaService {

	/** The fctr DAO. */
	@Inject
	private FacturaDAO fctrDAO;

	/** The vlrg DAO. */
	@Inject
	private ValoracionCargoDAO vlrgDAO;

	/** The vlri DAO. */
	@Inject
	private ValoracionImpuestoDAO vlriDAO;

	/** The vlrl DAO. */
	@Inject
	private ValoracionLineaDAO vlrlDAO;

	/** The vlrc DAO. */
	@Inject
	private ValoracionDAO vlrcDAO;

	/**
	 * Select imprimir.
	 *
	 * @param fctrIds
	 *            the fctr ids
	 * @param idioma
	 *            the idioma
	 * @return the list
	 */
	public List<FacturaImpresionVO> selectImprimir(Set<Long> fctrIds, String idioma) {
		Preconditions.checkArgument(!fctrIds.isEmpty());

		final List<FacturaImpresionVO> list = new ArrayList<>();

		for (final Long fctrId : fctrIds) {
			final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

			fctrCriterio.setId(fctrId);
			fctrCriterio.setIdioma(idioma);

			final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

			if (fctr != null) {
				final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

				vlrcCriterio.setFctr(fctr);
				vlrcCriterio.setIdioma(idioma);

				final List<ValoracionCargoVO> vlrgList = vlrgDAO.selectList(vlrcCriterio);
				final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectList(vlrcCriterio);

				final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

				vlrlCriterio.setFctrId(fctr.getId());

				final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterio);
				final Map<Long, ValoracionVO> vlrcMap = new HashMap<>();

				for (final ValoracionVO vlrc : vlrcDAO.selectList(vlrcCriterio)) {
					vlrcMap.put(vlrc.getId(), vlrc);
				}

				list.add(new FacturaImpresionVO(fctr, vlrgList, vlriList, vlrlList, vlrcMap));
			}
		}

		return list;
	}

	/**
	 * Select.
	 *
	 * @param fctrId
	 *            the fctr id
	 * @param idioma
	 *            the idioma
	 * @return the factura VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public FacturaVO select(@NonNull final Long fctrId, final String idioma) throws InstanceNotFoundException {
		final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

		fctrCriterio.setId(fctrId);
		fctrCriterio.setIdioma(idioma);

		final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

		if (fctr == null) {
			throw new InstanceNotFoundException(MessageI18nKey.fctr, fctrId);
		}

		return fctr;
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
	public PaginatedList<FacturaVO> selectList(@NonNull final FacturaCriterioVO fctrCriterio, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = fctrDAO.count(fctrCriterio);

		return new PaginatedList<FacturaVO>(
				count > offset ? fctrDAO.selectList(fctrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
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
	public List<FacturaVO> selectTypeaheadList(@NonNull final FacturaTypeaheadCriterioVO criterio, int limit) {
		Preconditions.checkNotNull(criterio.getTextoBusqueda());

		final StringTokenizer tokenizer = new StringTokenizer(criterio.getTextoBusqueda(), "/");

		criterio.setSerie(tokenizer.nextToken().toUpperCase() + "%");

		if (tokenizer.hasMoreTokens()) {
			criterio.setAnio(tokenizer.nextToken() + "%");
		}

		if (tokenizer.hasMoreTokens()) {
			criterio.setNumero(tokenizer.nextToken() + "%");
		}

		return fctrDAO.selectTypeaheadList(criterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

}
