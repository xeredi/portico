package xeredi.integra.model.servicio.edifact.escala;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bBaseVisitor;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.BermanContext;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.Gr1Context;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.Gr3Context;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.Gr4Context;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.Gr7Context;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.Gr8Context;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser.RffContext;

public final class BermanMaestroReader extends BermanD14bBaseVisitor {

	/** The maestro codes map. */
	private final Map<Entidad, Set<String>> maestroCodesMap = new HashMap<>();

	/** The nif set. */
	private final Set<String> nifSet = new HashSet<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitBerman(BermanContext ctx) {
		for (final Gr1Context gr1Context : ctx.gr1()) {
			switch (gr1Context.nad().f3035().getText()) {
			case "CV":
				nifSet.add(gr1Context.nad().c082().f3039().getText());
				break;
			case "OV":
				addCodigoMaestro(Entidad.NAVIERA, gr1Context.nad().c082().f3039().getText());
				break;
			default:
				break;
			}
		}

		for (final Gr3Context gr3Context : ctx.gr3()) {
			addCodigoMaestro(Entidad.TIPO_BUQUE_EDI, gr3Context.tdt().c001().f8179().getText());
			addCodigoMaestro(Entidad.BUQUE, gr3Context.tdt().c222().f8213().getText());
			addCodigoMaestro(Entidad.PAIS, gr3Context.tdt().c222().f8453().getText());

			for (final RffContext rffContext : gr3Context.rff()) {
				switch (rffContext.c506().f1153().getText()) {
				case "ZCS":
					addCodigoMaestro(Entidad.TIPO_SERVICIO_TRAFICO, rffContext.c506().f1154().getText());
					break;
				case "ZNG":
					addCodigoMaestro(Entidad.TIPO_CERTIFICADO, rffContext.c506().f1154().getText());
					break;
				default:
					break;
				}
			}

			for (final Gr4Context gr4Context : gr3Context.gr4()) {
				switch (gr4Context.loc().f3227().getText()) {
				case "92":
				case "153":
				case "61":
				case "229":
					addCodigoMaestro(Entidad.UNLOCODE, gr4Context.loc().c517().f3225().getText());
					break;
				}
			}
		}

		for (final Gr7Context gr7Context : ctx.gr7()) {
			addCodigoMaestro(Entidad.TIPO_ATRAQUE_EDI, gr7Context.tsr().c233().f7273(0).getText());

			for (final Gr8Context gr8Context : gr7Context.gr8()) {
				addCodigoMaestro(Entidad.ALINEACION, gr8Context.loc().c517().f3225().getText());
			}
		}

		return super.visitBerman(ctx);
	}

	/**
	 * Adds the codigo maestro.
	 *
	 * @param entidad
	 *            the entidad
	 * @param codigo
	 *            the codigo
	 */
	private void addCodigoMaestro(final Entidad entidad, final String codigo) {
		if (!maestroCodesMap.containsKey(entidad)) {
			maestroCodesMap.put(entidad, new HashSet<String>());
		}

		maestroCodesMap.get(entidad).add(codigo);
	}

	/**
	 * Gets the maestro codes map.
	 *
	 * @return the maestro codes map
	 */
	public Map<Entidad, Set<String>> getMaestroCodesMap() {
		return maestroCodesMap;
	}

	/**
	 * Gets the nif set.
	 *
	 * @return the nif set
	 */
	public Set<String> getNifSet() {
		return nifSet;
	}

}
