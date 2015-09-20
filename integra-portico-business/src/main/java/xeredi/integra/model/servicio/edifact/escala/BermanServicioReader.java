package xeredi.integra.model.servicio.edifact.escala;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.RuleContext;

import xeredi.edifact.grammar.BermanD14bBaseVisitor;
import xeredi.edifact.grammar.BermanD14bParser.BermanContext;
import xeredi.edifact.grammar.BermanD14bParser.DocContext;
import xeredi.edifact.grammar.BermanD14bParser.DtmContext;
import xeredi.edifact.grammar.BermanD14bParser.FtxContext;
import xeredi.edifact.grammar.BermanD14bParser.GdsContext;
import xeredi.edifact.grammar.BermanD14bParser.HanContext;
import xeredi.edifact.grammar.BermanD14bParser.LocContext;
import xeredi.edifact.grammar.BermanD14bParser.MeaContext;
import xeredi.edifact.grammar.BermanD14bParser.NadContext;
import xeredi.edifact.grammar.BermanD14bParser.PocContext;
import xeredi.edifact.grammar.BermanD14bParser.QtyContext;
import xeredi.edifact.grammar.BermanD14bParser.RffContext;
import xeredi.edifact.grammar.BermanD14bParser.TdtContext;
import xeredi.edifact.grammar.BermanD14bParser.TsrContext;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BermanServicioReader.
 */
public final class BermanServicioReader extends BermanD14bBaseVisitor {

	/** The maestro codes map. */
	private final Map<Entidad, Map<String, ParametroVO>> maestroMap;

	/** The nif set. */
	private final Map<String, ParametroVO> nifMap;

	/** The srvc. */
	private ServicioVO srvc;

	/** The buque. */
	private ParametroVO buque;

	/** The ssrv map. */
	private final Map<Entidad, List<SubservicioVO>> ssrvMap = new HashMap<>();

	/** The ssss map. */
	private final Map<Long, Long> ssssMap = new HashMap<Long, Long>();

	/** The atraque actual. */
	private SubservicioVO atraqueActual;

	/** The operacion actual. */
	private SubservicioVO operacionActual;

	/**
	 * Instantiates a new berman servicio reader.
	 *
	 * @param amaestroMap
	 *            the amaestro map
	 * @param anifMap
	 *            the anif map
	 */
	public BermanServicioReader(
			Map<Entidad, Map<String, ParametroVO>> amaestroMap,
			Map<String, ParametroVO> anifMap) {
		super();
		this.maestroMap = amaestroMap;
		this.nifMap = anifMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitBerman(BermanContext ctx) {
		final TipoServicioDetailVO tpsrDetail = TipoServicioProxy
				.select(Entidad.ESCALA.getId());

		srvc = new ServicioVO(tpsrDetail);

		final TipoParametroDetailVO tpprDetail = TipoParametroProxy
				.select(Entidad.BUQUE.getId());

		buque = new ParametroVO(tpprDetail);

		ssrvMap.put(Entidad.ATRAQUE, new ArrayList<SubservicioVO>());
		ssrvMap.put(Entidad.OPERACION_ATRAQUE, new ArrayList<SubservicioVO>());

		return super.visitBerman(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitFtx(FtxContext ctx) {
		switch (ctx.f4451().getText()) {
		case "AAI":
			srvc.addItdt(TipoDato.CADENA_06.getId(), ctx.c108().f4440(0)
					.getText());

			// FIXME Pueden ser observaciones de atraque o fondeo
			// FIXME Pueden ser Lugar de embarque/desembarque de operacion de
			// atraque o fondeo

			break;
		case "ACB":
			if (ctx.c107() != null) {
				switch (ctx.c107().f4441().getText()) {
				// FIXME Convenios de Buque y planes de residuos
				case "ZIE":
					buque.addItdt(TipoDato.BOOLEANO_07.getId(), 1L);

					break;
				case "ZIN":
					buque.addItdt(TipoDato.BOOLEANO_07.getId(), 1L);

					break;
				case "ZFU":
					srvc.addItdt(TipoDato.BOOLEANO_09.getId(), 1L);

					break;
				case "ZNF":
					srvc.addItdt(TipoDato.BOOLEANO_09.getId(), 0L);

					break;
				case "ZER":
					srvc.addItdt(TipoDato.BOOLEANO_12.getId(), 1L);

					break;
				case "ZCD":
					srvc.addItdt(TipoDato.BOOLEANO_03.getId(), 1L);

					break;
				case "ZDD":
					srvc.addItdt(TipoDato.BOOLEANO_05.getId(), 1L);

					break;
				case "ZBD":
					srvc.addItdt(TipoDato.BOOLEANO_04.getId(), 1L);

					break;
				case "ZNM":
					srvc.addItdt(TipoDato.BOOLEANO_02.getId(), 1L);

					break;
				case "ZAC":
					srvc.addItdt(TipoDato.BOOLEANO_08.getId(), 1L);

					break;
				case "Z2C":
					buque.addItdt(TipoDato.BOOLEANO_02.getId(), 1L);

					break;
				case "ZOB":
					buque.addItdt(TipoDato.CADENA_03.getId(),
							ctx.c108().f4440(0).getText());

					break;
				case "ZCL":
					srvc.addItdt(TipoDato.COND_TANQUE_CARGA.getId(), "L");

					break;
				case "ZCV":
					srvc.addItdt(TipoDato.COND_TANQUE_CARGA.getId(), "V");

					break;
				case "ZCI":
					srvc.addItdt(TipoDato.COND_TANQUE_CARGA.getId(), "I");

					break;
				case "ZLL":
					srvc.addItdt(TipoDato.COND_TANQUE_LASTRE.getId(), "L");

					break;
				case "ZLV":
					srvc.addItdt(TipoDato.COND_TANQUE_LASTRE.getId(), "V");

					break;
				case "ZOI":
					srvc.addItdt(TipoDato.BOOLEANO_15.getId(), 1L);
					srvc.addItdt(TipoDato.CADENA_12.getId(), ctx.c108()
							.f4440(0).getText());

					break;
				case "ZEP":
					atraqueActual.addItdt(TipoDato.BOOLEANO_08.getId(), 1L);

					break;
				case "ZEL":
					atraqueActual.addItdt(TipoDato.TIPO_ESTAN_ATR.getId(), "L");

					break;
				default:
					break;
				}
			}

			break;

		default:
			break;
		}

		return super.visitFtx(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitQty(QtyContext ctx) {
		switch (ctx.c186().f6063().getText()) {
		case "ZDP":
			buque.addItdt(TipoDato.ENTERO_15.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZTE":
			srvc.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZTS":
			srvc.addItdt(TipoDato.ENTERO_03.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZWE":
			srvc.addItdt(TipoDato.ENTERO_06.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZWS":
			srvc.addItdt(TipoDato.ENTERO_07.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZPE":
			srvc.addItdt(TipoDato.ENTERO_04.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		case "ZPS":
			srvc.addItdt(TipoDato.ENTERO_05.getId(), parseLong(ctx.c186()
					.f6060()));

			break;
		default:
			break;
		}

		return super.visitQty(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitNad(NadContext ctx) {
		switch (ctx.f3035().getText()) {
		case "CV":
			srvc.addItdt(TipoDato.ORGA_3.getId(), getOrganizacion(ctx.c082()
					.f3039().getText()));

			break;
		case "TR":
			operacionActual.addItdt(TipoDato.ORGA.getId(), getOrganizacion(ctx
					.c082().f3039().getText()));

			break;
		case "OV":
			// FIXME Donde se mete la naviera
			getMaestro(Entidad.NAVIERA, ctx.c082().f3039().getText());

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
		srvc.addItdt(TipoDato.CADENA_04.getId(), ctx.c040().f3126().getText());

		buque.setParametro(ctx.c222().f8213().getText());
		buque.addItdt(TipoDato.CADENA_01.getId(), ctx.c222().f8212().getText());
		buque.addItdt(TipoDato.PAIS.getId(),
				getMaestro(Entidad.PAIS, ctx.c222().f8453().getText()));

		final ParametroVO tipoBuqueEdi = getMaestro(Entidad.TIPO_BUQUE_EDI, ctx
				.c001().f8179().getText());

		// FIXME
		// buque.addItdt(TipoDato.TIPO_BUQUE.getId(),
		// tipoBuqueEdi.getItdt(TipoDato.TIPO_BUQUE.getId()).getPrmt());

		return super.visitTdt(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitRff(RffContext ctx) {
		switch (ctx.c506().f1153().getText()) {
		case "VM":
			buque.addItdt(TipoDato.CADENA_02.getId(), ctx.c506().f1154()
					.getText());

			break;
		case "ZIO":
			buque.addItdt(TipoDato.CADENA_06.getId(), ctx.c506().f1154()
					.getText());

			break;
		case "ZIC":
			buque.addItdt(TipoDato.CADENA_05.getId(), ctx.c506().f1154()
					.getText());

			break;
		case "ZSC":
			buque.addItdt(TipoDato.CADENA_04.getId(), ctx.c506().f1154()
					.getText());

			break;
		case "ZCS":
			// FIXME
			break;
		case "ZGS":
			// FIXME
			break;
		case "ZNG":
			// FIXME
			break;
		case "ZSB":
			buque.addItdt(TipoDato.ENTERO_05.getId(), parseLong(ctx.c506()
					.f1154()));

			break;
		case "ZAE":
			buque.addItdt(TipoDato.BOOLEANO_04.getId(), 1L);

			break;
		case "ZAN":
			buque.addItdt(TipoDato.BOOLEANO_04.getId(), 0L);

			break;
		case "ZME":
			buque.addItdt(TipoDato.BOOLEANO_14.getId(), 1L);

			break;
		case "ZNM":
			buque.addItdt(TipoDato.BOOLEANO_14.getId(), 0L);

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
	public Object visitDtm(DtmContext ctx) {
		switch (ctx.c507().f2005().getText()) {
		case "132":
			srvc.setFini(parseDate(ctx.c507().f2380(), "yyyyMMddHHmm"));

			break;
		case "133":
			srvc.setFfin(parseDate(ctx.c507().f2380(), "yyyyMMddHHmm"));

			break;
		case "36":
			// FIXME

			break;
		case "183":
			buque.addItdt(TipoDato.FECHA_03.getId(),
					parseDate(ctx.c507().f2380(), "yyyyMMdd"));

			break;
		case "379":
			buque.addItdt(TipoDato.FECHA_05.getId(),
					parseDate(ctx.c507().f2380(), "yyyyMMdd"));

			break;
		case "178":
			atraqueActual
					.setFini(parseDate(ctx.c507().f2380(), "yyyyMMddHHmm"));

			break;
		case "189":
			atraqueActual
					.setFfin(parseDate(ctx.c507().f2380(), "yyyyMMddHHmm"));

			break;
		case "291":
			// FIXME Fecha inicio operaciones

			break;
		case "292":
			// FIXME Fecha fin operaciones

			break;

		default:
			break;
		}

		return super.visitDtm(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitMea(MeaContext ctx) {
		switch (ctx.f6311().getText()) {
		case "AAE":
			switch (ctx.c502().f6313().getText()) {
			case "ZMD":
				buque.addItdt(TipoDato.DECIMAL_02.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			case "WM":
				buque.addItdt(TipoDato.DECIMAL_04.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			case "HM":
				buque.addItdt(TipoDato.DECIMAL_05.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			case "HT":
				buque.addItdt(TipoDato.DECIMAL_06.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			case "ZMP":
				buque.addItdt(TipoDato.ENTERO_06.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			case "ZTL":
				buque.addItdt(TipoDato.UNID_MED_SBT.getId(), ctx.c174().f6411()
						.getText());
				buque.addItdt(TipoDato.ENTERO_05.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			case "ZAD":
				atraqueActual.addItdt(TipoDato.DECIMAL_03.getId(),
						parseDouble(ctx.c174().f6314()));

				break;
			case "ZDD":
				atraqueActual.addItdt(TipoDato.DECIMAL_04.getId(),
						parseDouble(ctx.c174().f6314()));

				break;
			case "WT":
			case "AAW":
			case "LM":
				operacionActual.addItdt(TipoDato.UNID_MED_BERMAN.getId(), ctx
						.c174().f6411().getText());
				operacionActual.addItdt(TipoDato.DECIMAL_02.getId(),
						parseDouble(ctx.c174().f6314()));

				break;
			default:
				break;
			}
			break;
		case "LAO":
			switch (ctx.c502().f6313().getText()) {
			case "LM":
				buque.addItdt(TipoDato.DECIMAL_03.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			default:
				break;
			}
			break;
		case "WT":
			switch (ctx.c502().f6313().getText()) {
			case "AAM":
				buque.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			case "ZDW":
				buque.addItdt(TipoDato.ENTERO_04.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			default:
				break;
			}
			break;
		case "ABS":
			switch (ctx.c502().f6313().getText()) {
			case "ZVC":
				buque.addItdt(TipoDato.DECIMAL_07.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			case "ZVM":
				buque.addItdt(TipoDato.DECIMAL_08.getId(), parseDouble(ctx
						.c174().f6314()));

				break;
			default:
				break;
			}
			break;
		case "CT":
			switch (ctx.c502().f6313().getText()) {
			case "ZHE":
				buque.addItdt(TipoDato.ENTERO_10.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			case "U":
				operacionActual.addItdt(TipoDato.UNID_MED_BERMAN.getId(), ctx
						.c174().f6411().getText());
				operacionActual.addItdt(TipoDato.DECIMAL_01.getId(),
						parseDouble(ctx.c174().f6314()));

				break;
			default:
				break;
			}
			break;
		case "ACG":
			switch (ctx.c502().f6313().getText()) {
			case "ZVL":
				srvc.addItdt(TipoDato.ENTERO_10.getId(), parseLong(ctx.c174()
						.f6314()));

				break;
			default:
				break;
			}
			break;
		default:
			break;
		}

		return super.visitMea(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitLoc(LocContext ctx) {
		switch (ctx.f3227().getText()) {
		case "153":
			// FIXME Puerto Escala

			break;
		case "92":
			srvc.addItdt(TipoDato.UNLOCODE_2.getId(),
					getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

			break;
		case "61":
			srvc.addItdt(TipoDato.UNLOCODE.getId(),
					getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

			break;
		case "229":
			buque.addItdt(TipoDato.UNLOCODE.getId(),
					getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

			break;
		case "60":
			// FIXME Alineacion Atraque

			break;
		default:
			break;
		}

		return super.visitLoc(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitDoc(DocContext ctx) {
		switch (ctx.c002().f1001().getText()) {
		case "ZCA":
			if (ctx.c503() != null) {
				buque.addItdt(TipoDato.CADENA_09.getId(), ctx.c503().f1004()
						.getText());
			}

			break;

		default:
			break;
		}

		return super.visitDoc(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitTsr(TsrContext ctx) {
		atraqueActual = new SubservicioVO(
				TipoSubservicioProxy.select(Entidad.ATRAQUE.getId()));

		ssrvMap.get(Entidad.ATRAQUE).add(atraqueActual);

		atraqueActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));

		final String codigoAtraque = ctx.c233().f7273(0).getText();

		if (!"SEC".equals(codigoAtraque)) {
			atraqueActual.addItdt(
					TipoDato.TIPO_ATR_EDI.getId(),
					getMaestro(Entidad.TIPO_ATRAQUE_EDI, ctx.c233().f7273(1)
							.getText()));

			atraqueActual.addItdt(TipoDato.BOOLEANO_03.getId(), 0L);
			atraqueActual.addItdt(TipoDato.BOOLEANO_04.getId(), 0L);
			atraqueActual.addItdt(TipoDato.BOOLEANO_05.getId(), 0L);
			atraqueActual.addItdt(TipoDato.BOOLEANO_06.getId(), 0L);
			atraqueActual.addItdt(TipoDato.BOOLEANO_07.getId(), 0L);
			atraqueActual.addItdt(TipoDato.BOOLEANO_08.getId(), 0L);
			atraqueActual.addItdt(TipoDato.TIPO_ESTAN_ATR.getId(), "C");
			atraqueActual.addItdt(TipoDato.DECIMAL_05.getId(), 0.0);
			atraqueActual.addItdt(TipoDato.DECIMAL_06.getId(), 0.0);
			atraqueActual.addItdt(TipoDato.COD_EXEN.getId(), "0");
			atraqueActual.addItdt(TipoDato.DECIMAL_03.getId(),
					buque.getItdt(TipoDato.DECIMAL_02.getId())
							.getCantidadDecimal());
			atraqueActual.addItdt(TipoDato.DECIMAL_04.getId(),
					buque.getItdt(TipoDato.DECIMAL_02.getId())
							.getCantidadDecimal());

			// FIXME EmisorEDIAtr EmisorEDIAtr
			// FIXME SubpConsigAtr v_SubpEsc (tratado en el NAD)
			// FIXME CodConsigAtr v_CodCliente (tratado en el NAD)
		}
		// FIXME numero Edi
		// atraqueActual.addItdt(TipoDato.ENTERO_01.getId(),
		// parseLong(context.c233().f7273(0)));

		return super.visitTsr(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitPoc(PocContext ctx) {
		final String codTipoActEdi = ctx.c525().f8025().getText();

		atraqueActual.addItdt(TipoDato.TIPO_ACTIVIDAD_EDI.getId(),
				getMaestro(Entidad.TIPO_ACTIVIDAD_EDI, codTipoActEdi));

		switch (codTipoActEdi) {
		case "ZSA":
			atraqueActual.addItdt(TipoDato.BOOLEANO_07.getId(), 1L);

			break;
		case "ZSH":
			atraqueActual.addItdt(TipoDato.BOOLEANO_06.getId(), 1L);

			break;
		case "ZSE":
			atraqueActual.addItdt(TipoDato.BOOLEANO_03.getId(), 1L);

			break;
		case "ZSC":
			atraqueActual.addItdt(TipoDato.BOOLEANO_05.getId(), 1L);

			break;

		default:
			break;
		}

		return super.visitPoc(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitHan(HanContext ctx) {
		operacionActual = new SubservicioVO(
				TipoSubservicioProxy.select(Entidad.OPERACION_ATRAQUE.getId()));

		ssrvMap.get(Entidad.OPERACION_ATRAQUE).add(atraqueActual);

		operacionActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));

		operacionActual.addItdt(
				TipoDato.TIPO_OP_MERC.getId(),
				getMaestro(Entidad.TIPO_OPERACION_MERCANCIA, ctx.c524().f4079()
						.getText()));

		return super.visitHan(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitGds(GdsContext ctx) {
		operacionActual
				.addItdt(
						TipoDato.TIPO_MERC.getId(),
						getMaestro(Entidad.TIPO_MERCANCIA, ctx.c703().f7085()
								.getText()));

		return super.visitGds(ctx);
	}

	/**
	 * Gets the maestro.
	 *
	 * @param entidad
	 *            the entidad
	 * @param codigo
	 *            the codigo
	 * @return the maestro
	 */
	private ParametroVO getMaestro(final Entidad entidad, final String codigo) {
		if (!maestroMap.containsKey(entidad)) {
			throw new Error("Immplementar 1");
		}

		if (!maestroMap.get(entidad).containsKey(codigo)) {
			throw new Error("Immplementar 2");
		}

		return maestroMap.get(entidad).get(codigo);
	}

	/**
	 * Gets the organizacion.
	 *
	 * @param nif
	 *            the nif
	 * @return the organizacion
	 */
	private ParametroVO getOrganizacion(final String nif) {
		if (!nifMap.containsKey(nif)) {
			throw new Error("Immplementar 3");
		}

		return nifMap.get(nif);
	}

	/**
	 * Parses the long.
	 *
	 * @param context
	 *            the context
	 * @return the long
	 */
	private Long parseLong(final RuleContext context) {
		return Long.parseLong(context.getText());
	}

	/**
	 * Parses the double.
	 *
	 * @param context
	 *            the context
	 * @return the double
	 */
	private Double parseDouble(final RuleContext context) {
		return Double.parseDouble(context.getText());
	}

	/**
	 * Parses the date.
	 *
	 * @param context
	 *            the context
	 * @param dateFormat
	 *            the date format
	 * @return the date
	 */
	private Date parseDate(final RuleContext context, final String dateFormat) {
		try {
			final DateFormat format = new SimpleDateFormat(dateFormat);

			return format.parse(context.getText());
		} catch (final ParseException ex) {
			throw new Error(ex);
		}
	}

	/**
	 * Gets the srvc.
	 *
	 * @return the srvc
	 */
	public ServicioVO getSrvc() {
		return srvc;
	}

	/**
	 * Gets the buque.
	 *
	 * @return the buque
	 */
	public ParametroVO getBuque() {
		return buque;
	}

	/**
	 * Gets the ssrv map.
	 *
	 * @return the ssrv map
	 */
	public Map<Entidad, List<SubservicioVO>> getSsrvMap() {
		return ssrvMap;
	}

	/**
	 * Gets the ssss map.
	 *
	 * @return the ssss map
	 */
	public Map<Long, Long> getSsssMap() {
		return ssssMap;
	}
}
