package xeredi.integra.model.servicio.edifact.manifiesto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bBaseVisitor;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.CniContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.Gr17Context;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.Gr18Context;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.Gr27Context;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.Gr32Context;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.Gr9Context;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.IfcsumContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.LocContext;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumMaestroReader.
 */
public final class IfcsumMaestroReader extends IfcsumD14bBaseVisitor {

	/** The maestro codes map. */
	private final Map<Entidad, Set<String>> maestroCodesMap = new HashMap<>();

	/** The nif set. */
	private final Set<String> nifSet = new HashSet<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitIfcsum(IfcsumContext ctx) {
		for (final Gr9Context gr9Context : ctx.gr9()) {
			addCodigoMaestro(Entidad.MODO_TRANSPORTE_EDI, gr9Context.tdt().c220().f8067().getText());

			for (final Gr17Context gr17Context : gr9Context.gr17()) {
				addCodigoMaestro(Entidad.TERMINAL, gr17Context.rff().c506().f1154().getText()); // FIXME
			}

			for (final Gr18Context gr18Context : gr9Context.gr18()) {
				nifSet.add(gr18Context.nad().c082().f3039().getText());

				for (final LocContext locContext : gr18Context.loc()) {
					addCodigoMaestro(Entidad.ALINEACION, locContext.c517().f3225().getText());
				}
			}
		}

		// BL
		for (final Gr27Context gr27Context : ctx.gr27()) {
			for (final Gr32Context gr32Context : gr27Context.gr32()) {
				addCodigoMaestro(Entidad.UNLOCODE, gr32Context.loc().c517().f3225().getText());
			}
		}

		return super.visitIfcsum(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitCni(CniContext ctx) {

		// TODO Auto-generated method stub
		return super.visitCni(ctx);
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
