package xeredi.argo.model.servicio.edifact.escala;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.edifact.grammar.BermanD14bBaseVisitor;
import xeredi.edifact.grammar.BermanD14bParser.BermanContext;
import xeredi.edifact.grammar.BermanD14bParser.GdsContext;
import xeredi.edifact.grammar.BermanD14bParser.HanContext;
import xeredi.edifact.grammar.BermanD14bParser.LocContext;
import xeredi.edifact.grammar.BermanD14bParser.NadContext;
import xeredi.edifact.grammar.BermanD14bParser.PocContext;
import xeredi.edifact.grammar.BermanD14bParser.RffContext;
import xeredi.edifact.grammar.BermanD14bParser.TdtContext;
import xeredi.edifact.grammar.BermanD14bParser.TsrContext;

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
		return super.visitBerman(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitNad(NadContext ctx) {
		switch (ctx.f3035().getText()) {
		case "CV":
		case "TR":
			nifSet.add(ctx.c082().f3039().getText());
			break;
		case "OV":
			addCodigoMaestro(Entidad.NAVIERA, ctx.c082().f3039().getText());
			break;
		default:
			break;
		}

		return super.visitNad(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitTdt(TdtContext ctx) {
		addCodigoMaestro(Entidad.TIPO_BUQUE_EDI, ctx.c001().f8179().getText());
		addCodigoMaestro(Entidad.BUQUE, ctx.c222().f8213().getText());
		addCodigoMaestro(Entidad.PAIS, ctx.c222().f8453().getText());

		return super.visitTdt(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitRff(RffContext ctx) {
		switch (ctx.c506().f1153().getText()) {
		case "ZCS":
			addCodigoMaestro(Entidad.TIPO_SERVICIO_TRAFICO, ctx.c506().f1154()
					.getText());
			break;
		case "ZNG":
			addCodigoMaestro(Entidad.TIPO_CERTIFICADO, ctx.c506().f1154()
					.getText());
			break;
		default:
			break;
		}

		return super.visitRff(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitLoc(LocContext ctx) {
		switch (ctx.f3227().getText()) {
		case "92":
		case "153":
		case "61":
		case "229":
			addCodigoMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText());
			break;
		case "60":
			addCodigoMaestro(Entidad.ALINEACION, ctx.c517().f3225().getText());
			break;
		}

		return super.visitLoc(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitTsr(TsrContext ctx) {
		final String codigoAtraque = ctx.c233().f7273(0).getText();

		if (!"SEC".equals(codigoAtraque)) {
			addCodigoMaestro(Entidad.TIPO_ATRAQUE_EDI, ctx.c233().f7273(1)
					.getText());
		}

		return super.visitTsr(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitPoc(PocContext ctx) {
		addCodigoMaestro(Entidad.TIPO_ACTIVIDAD_EDI, ctx.c525().f8025()
				.getText());

		return super.visitPoc(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitHan(HanContext ctx) {
		addCodigoMaestro(Entidad.TIPO_OPERACION_MERCANCIA, ctx.c524().f4079()
				.getText());

		return super.visitHan(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitGds(GdsContext ctx) {
		addCodigoMaestro(Entidad.TIPO_MERCANCIA, ctx.c703().f7085().getText());

		return super.visitGds(ctx);
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
