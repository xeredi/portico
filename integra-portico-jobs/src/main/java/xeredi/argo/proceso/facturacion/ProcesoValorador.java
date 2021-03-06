package xeredi.argo.proceso.facturacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.inject.Inject;

import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.facturacion.service.ValoradorService;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoValorador.
 */
public final class ProcesoValorador extends ProcesoTemplate {

	@Inject
	private ValoradorService vldrService;

	/**
	 * The Enum Params.
	 */
	public enum Params {
		/** The fliq. */
		fliq,
		/** The crgo. */
		crgo
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void prepararProcesos() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void ejecutarProceso() {
		final String fliqString = prbtData.getPrpmMap().get(Params.fliq.name()).getValor();

		try {
			final Date fliq = new SimpleDateFormat("dd/MM/yyyy").parse(fliqString);
			final Set<Long> crgoIds = new HashSet<>();

			final ProcesoParametroVO prpmCrgoIds = prbtData.getPrpmMap().get(Params.crgo.name());

			if (prpmCrgoIds != null) {
				final StringTokenizer tokenizer = new StringTokenizer(prpmCrgoIds.getValor());

				while (tokenizer.hasMoreTokens()) {
					crgoIds.add(Long.parseLong(tokenizer.nextToken()));
				}
			}

			for (final ProcesoItemVO pritEntrada : prbtData.getPritEntradaList()) {
				try {
					final List<Long> vlrcIds = vldrService.valorarServicio(prbtData.getPrbt(), pritEntrada.getItemId(),
							crgoIds, fliq);

					for (final Long vlrcId : vlrcIds) {
						addPritSalida(vlrcId);
					}
				} catch (final ModelException ex) {
					addError(MensajeCodigo.G_000, ex.getMessage());
				}
			}
		} catch (final ParseException ex) {
			throw new Error(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProcesoTipo getProcesoTipo() {
		return ProcesoTipo.VALORADOR;
	}

}
