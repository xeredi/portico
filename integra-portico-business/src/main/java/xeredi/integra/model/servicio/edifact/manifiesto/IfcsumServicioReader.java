package xeredi.integra.model.servicio.edifact.manifiesto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.antlr.v4.runtime.RuleContext;

import xeredi.edifact.grammar.IfcsumD14bBaseVisitor;
import xeredi.edifact.grammar.IfcsumD14bParser.BgmContext;
import xeredi.edifact.grammar.IfcsumD14bParser.CniContext;
import xeredi.edifact.grammar.IfcsumD14bParser.DgsContext;
import xeredi.edifact.grammar.IfcsumD14bParser.DocContext;
import xeredi.edifact.grammar.IfcsumD14bParser.DtmContext;
import xeredi.edifact.grammar.IfcsumD14bParser.EqdContext;
import xeredi.edifact.grammar.IfcsumD14bParser.EqnContext;
import xeredi.edifact.grammar.IfcsumD14bParser.FtxContext;
import xeredi.edifact.grammar.IfcsumD14bParser.GidContext;
import xeredi.edifact.grammar.IfcsumD14bParser.GorContext;
import xeredi.edifact.grammar.IfcsumD14bParser.IfcsumContext;
import xeredi.edifact.grammar.IfcsumD14bParser.LocContext;
import xeredi.edifact.grammar.IfcsumD14bParser.MeaContext;
import xeredi.edifact.grammar.IfcsumD14bParser.NadContext;
import xeredi.edifact.grammar.IfcsumD14bParser.PciContext;
import xeredi.edifact.grammar.IfcsumD14bParser.RffContext;
import xeredi.edifact.grammar.IfcsumD14bParser.SelContext;
import xeredi.edifact.grammar.IfcsumD14bParser.SgpContext;
import xeredi.edifact.grammar.IfcsumD14bParser.TdtContext;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumServicioReader.
 */
public final class IfcsumServicioReader extends IfcsumD14bBaseVisitor {

    /**
     * The Enum ElementoActual.
     */
    enum ElementoActual {

        /** The mani. */
        mani, /** The mabl. */
        mabl, /** The part. */
        part, /** The equi. */
        equi
    };

    /** The elemento actual. */
    private ElementoActual elementoActual;

    /** The funcion. */
    private String funcion;

    /** The maestro codes map. */
    private final Map<Entidad, Map<String, ParametroVO>> maestroMap;

    /** The nif set. */
    private final Map<String, ParametroVO> nifMap;

    /** The prto. */
    private final PuertoVO prto;

    /** The escala. */
    private final ServicioVO escala;

    /** The srvc. */
    private ServicioVO srvc;

    /** The ssrv map. */
    private final List<SubservicioVO> ssrvList = new ArrayList<>();

    /** The ssss list. */
    private final List<SubservicioSubservicioVO> ssssList = new ArrayList<>();

    /** The ssss map. */
    private final Map<Long, Set<Long>> ssssMap = new HashMap<>();

    /** The maco map. */
    private final Map<String, SubservicioVO> macoMap = new HashMap<>();

    /**
     * Relacion entre partidas y equipamientos, {@link Map} indexado por matricula de equipamiento, valor el
     * {@link List} de partida-equipamiento.
     */
    private final Map<String, List<SubservicioVO>> paeqMap = new HashMap<>();

    /** The contador. */
    private int contador = 0;

    /** The maco actual. */
    private SubservicioVO macoActual;

    /** The bl actual. */
    private SubservicioVO blActual;

    /** The partida actual. */
    private SubservicioVO partActual;

    /** The paim actual. */
    private SubservicioVO paimActual;

    /** The pamp actual. */
    private SubservicioVO pampActual;

    /** The paeq actual. */
    private SubservicioVO paeqActual;

    /** The pado actual. */
    private SubservicioVO padoActual;

    /** The equi actual. */
    private SubservicioVO equiActual;

    /** The preq actual. */
    private SubservicioVO preqActual;

    /**
     * Instantiates a new ifcsum servicio reader.
     *
     * @param aprto
     *            the aprto
     * @param aescala
     *            the aescala
     * @param amaestroMap
     *            the amaestro map
     * @param anifMap
     *            the anif map
     */
    public IfcsumServicioReader(final PuertoVO aprto, final ServicioVO aescala,
            final Map<Entidad, Map<String, ParametroVO>> amaestroMap, final Map<String, ParametroVO> anifMap) {
        super();
        prto = aprto;
        escala = aescala;
        maestroMap = amaestroMap;
        nifMap = anifMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitIfcsum(final IfcsumContext ctx) {
        final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(Entidad.MANIFIESTO.getId());

        elementoActual = ElementoActual.mani;

        srvc = new ServicioVO(tpsrDetail);

        srvc.setPrto(prto);
        srvc.setFref(escala.getFref());
        srvc.setAnno(escala.getAnno());
        srvc.addItdt(TipoDato.ESCALA.getId(), escala);
        srvc.addItdt(TipoDato.BOOLEANO_01.getId(), 1L);

        return super.visitIfcsum(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitBgm(final BgmContext ctx) {
        funcion = ctx.f1225().getText();

        switch (ctx.c002().f1001().getText()) {
        case "833":
            srvc.addItdt(TipoDato.TIPO_OPER_MANIF.getId(), "C");

            break;
        case "785":
            srvc.addItdt(TipoDato.TIPO_OPER_MANIF.getId(), "D");

            break;
        default:
            break;
        }

        final String numeroDocumento = ctx.c106().f1004().getText();

        srvc.addItdt(TipoDato.CADENA_01.getId(), numeroDocumento);

        return super.visitBgm(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitNad(final NadContext ctx) {
        switch (ctx.f3035().getText()) {
        case "CV":
            srvc.addItdt(TipoDato.ORGA_2.getId(), getOrganizacion(ctx.c082().f3039().getText().substring(2)));

            break;
        case "CN":
            final String nif = ctx.c082().f3039().getText().substring(2);

            if (!macoMap.containsKey(nif)) {
                final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy
                        .select(Entidad.MANIFIESTO_CONSIGNATARIO.getId());

                macoActual = new SubservicioVO(tpssDetail);

                macoActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
                macoActual.setNumero(contador++);
                macoActual.addItdt(TipoDato.ORGA.getId(), getOrganizacion(nif));

                macoMap.put(nif, macoActual);
                ssrvList.add(macoActual);
            }

            break;
        case "TR":
            srvc.addItdt(TipoDato.ORGA.getId(), getOrganizacion(ctx.c082().f3039().getText()));

            // FIXME Como saber si es de Manifiesto, Bl, partida...

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
    public Object visitCni(final CniContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.BL.getId());

        elementoActual = ElementoActual.mabl;

        blActual = new SubservicioVO(tpssDetail);

        blActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        blActual.setNumero(contador++);
        blActual.setEstado("I"); // FIXME Calcular
        blActual.addItdt(TipoDato.COD_EXEN.getId(), "0"); // FIXME Calcular
        blActual.addItdt(TipoDato.BOOLEANO_01.getId(), 0L);
        blActual.addItdt(TipoDato.BOOLEANO_02.getId(), srvc.getItdt(TipoDato.BOOLEANO_03.getId()).getCantidadEntera());

        ssrvList.add(blActual);
        addSsss(macoActual, blActual);

        blActual.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.f1490()));
        blActual.addItdt(TipoDato.CADENA_01.getId(), ctx.c503().f1004().getText());

        switch (ctx.c503().f1373().getText()) {
        case "ZZ1":
            blActual.addItdt(TipoDato.TIPO_BL.getId(), "M");

            break;
        case "ZZ2":
            blActual.addItdt(TipoDato.TIPO_BL.getId(), "P");

            break;
        case "ZZ3":
            blActual.addItdt(TipoDato.TIPO_BL.getId(), "V");

            break;

        default:
            break;
        }

        return super.visitCni(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitGid(final GidContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PARTIDA.getId());

        elementoActual = ElementoActual.part;

        partActual = new SubservicioVO(tpssDetail);

        partActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        partActual.setNumero(contador++);
        partActual.setEstado("R");
        partActual.addItdt(TipoDato.COD_EXEN.getId(), "0"); // FIXME Calcular

        ssrvList.add(partActual);
        addSsss(blActual, partActual);

        partActual.setNumero(parseInteger(ctx.f1496()));
        partActual.addItdt(TipoDato.TIPO_BULTO.getId(), getMaestro(Entidad.TIPO_BULTO, ctx.c213(0).f7065().getText()));

        switch (blActual.getItdt(TipoDato.TIPO_BL.getId()).getCadena()) {
        case "P":
            partActual.addItdt(TipoDato.ENTERO_03.getId(), parseLong(ctx.c213(0).f7224()));

            break;
        case "M":
            partActual.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.c213(0).f7224()));

            break;

        default:
            break;
        }

        return super.visitGid(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitGor(final GorContext ctx) {
        switch (ctx.f8323().getText()) {
        case "1":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "CA");

            break;
        case "ZCL":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "CL");

            break;
        case "ZSC":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "SC");

            break;
        case "2":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "DE");

            break;
        case "ZDL":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "DL");

            break;
        case "ZSD":
            srvc.addItdt(TipoDato.TIPO_MANIF.getId(), "SD");

            break;
        case "ZRE":
            srvc.addItdt(TipoDato.BOOLEANO_02.getId(), 1L);

            break;
        case "ZNR":
            srvc.addItdt(TipoDato.BOOLEANO_02.getId(), 0L);

            break;
        case "ZS1":
            srvc.addItdt(TipoDato.TRANS_SIMPL.getId(), "ZS1");
            srvc.addItdt(TipoDato.BOOLEANO_03.getId(), 1L);

            break;
        case "ZS2":
            srvc.addItdt(TipoDato.TRANS_SIMPL.getId(), "ZS2");
            srvc.addItdt(TipoDato.BOOLEANO_03.getId(), 1L);

            break;
        case "ZS4":
            srvc.addItdt(TipoDato.TRANS_SIMPL.getId(), "ZS4");
            srvc.addItdt(TipoDato.BOOLEANO_03.getId(), 0L);

            break;

        default:
            break;
        }
        final String tipoManifiestoEdi = ctx.f8323().getText();

        // FIXME Convertir formato

        // TODO Auto-generated method stub
        return super.visitGor(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitLoc(final LocContext ctx) {
        switch (ctx.f3227().getText()) {
        case "14":
            switch (elementoActual) {
            case mani:
                srvc.addItdt(TipoDato.ALIN.getId(), getMaestro(Entidad.ALINEACION, ctx.c517().f3225().getText()));

                break;
            case mabl:
                blActual.addItdt(TipoDato.ALIN.getId(), getMaestro(Entidad.ALINEACION, ctx.c517().f3225().getText()));

                break;
            default:
                throw new Error("Alineacion no esperada en elemento: " + elementoActual);
            }

            break;
        case "5":
            blActual.addItdt(TipoDato.UNLOCODE.getId(), getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

            break;
        case "9":
            blActual.addItdt(TipoDato.UNLOCODE_2.getId(), getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));
            blActual.addItdt(TipoDato.UNLOCODE_3.getId(), getMaestro(Entidad.UNLOCODE, srvc.getPrto().getUnlocode()));

            break;
        case "11":
            blActual.addItdt(TipoDato.UNLOCODE_2.getId(), getMaestro(Entidad.UNLOCODE, srvc.getPrto().getUnlocode()));
            blActual.addItdt(TipoDato.UNLOCODE_3.getId(), getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

            break;
        case "8":
            blActual.addItdt(TipoDato.UNLOCODE_4.getId(), getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

            break;
        case "13":
            blActual.addItdt(TipoDato.UNLOCODE_5.getId(), getMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText()));

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
    public Object visitRff(final RffContext ctx) {
        switch (ctx.c506().f1153().getText()) {
        case "ZRS":
            srvc.addItdt(TipoDato.BOOLEANO_03.getId(), "SI".equals(ctx.c506().f1154().getText()) ? 1L : 0L);

            break;
        case "XC":
            srvc.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.c506().f1154()));

            break;
        case "ZTC":
            final ParametroVO terminal = getMaestro(Entidad.TERMINAL, ctx.c506().f1154().getText());
            final ParametroVO instalacionEspecial = getMaestro(Entidad.INSTALACION_ESPECIAL,
                    ctx.c506().f1154().getText());

            if (terminal != null) {
                switch (elementoActual) {
                case mani:
                    srvc.addItdt(TipoDato.TERMINAL.getId(), terminal);

                    break;
                case mabl:
                    blActual.addItdt(TipoDato.TERMINAL.getId(), terminal);

                    break;
                case part:
                    partActual.addItdt(TipoDato.TERMINAL.getId(), terminal);

                    break;
                default:
                    throw new Error("Terminal no esperada en el elemento: " + elementoActual);
                }
            }

            if (instalacionEspecial != null) {
                switch (elementoActual) {
                case mabl:
                    blActual.addItdt(TipoDato.INST_ESP.getId(), instalacionEspecial);

                    break;
                case part:
                    partActual.addItdt(TipoDato.INST_ESP.getId(), instalacionEspecial);

                    break;
                default:
                    throw new Error("Terminal no esperada en el elemento: " + elementoActual);
                }
            }

            break;
        case "ZBC":
            final ParametroVO acuerdo = getMaestro(Entidad.ACUERDO, ctx.c506().f1154().getText());

            switch (elementoActual) {
            case mani:
                srvc.addItdt(TipoDato.ACUERDO.getId(), acuerdo);

                break;
            case mabl:
                blActual.addItdt(TipoDato.ACUERDO.getId(), acuerdo);

                break;
            case part:
                partActual.addItdt(TipoDato.ACUERDO.getId(), acuerdo);

                break;
            default:
                throw new Error("Terminal no esperada en el elemento: " + elementoActual);
            }

            break;
        case "ZLS":
            srvc.addItdt(TipoDato.SERV_TRAF.getId(),
                    getMaestro(Entidad.SERVICIO_TRAFICO, ctx.c506().f1154().getText()));

            // FIXME Como saber si es de Manifiesto, Bl, partida...

            break;
        case "AEI":
        case "AFB":
            blActual.addItdt(TipoDato.CADENA_02.getId(), ctx.c506().f1154().getText());
            // FIXME Orden?

            break;
        case "ZHA":
        case "ZEM":
        case "ZPE":
            blActual.addItdt(TipoDato.TIPO_DEST.getId(), ctx.c506().f1154().getText());

            break;
        case "ABD":
            partActual.addItdt(TipoDato.MERCANCIA.getId(), getMaestro(Entidad.MERCANCIA, ctx.c506().f1154().getText()));

            break;
        case "ZMV":
            partActual.addItdt(TipoDato.MARCA_VEHIC.getId(),
                    getMaestro(Entidad.MARCA_VEHICULO, ctx.c506().f1154().getText()));

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
    public Object visitDtm(final DtmContext ctx) {
        final Date fecha = parseDate(ctx.c507().f2380(), ctx.c507().f2379());

        switch (ctx.c507().f2005().getText()) {
        case "137":
            if (padoActual == null) {
                srvc.addItdt(TipoDato.FECHA_01.getId(), fecha);
            } else {
                padoActual.addItdt(TipoDato.FECHA_01.getId(), fecha);
            }

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
    public Object visitTdt(final TdtContext ctx) {
        switch (ctx.f8051().getText()) {
        case "20":
            srvc.addItdt(TipoDato.CADENA_02.getId(), ctx.c220().f8067().getText());

            break;
        case "10":
        case "30":
            final ParametroVO modoTransporteEdi = getMaestro(Entidad.MODO_TRANSPORTE_EDI, ctx.c220().f8067().getText());

            blActual.addItdt(TipoDato.MODO_TRANS_EDI.getId(), modoTransporteEdi);
            blActual.addItdt(TipoDato.TIPO_TRANSPORTE.getId(),
                    modoTransporteEdi.getItdt(TipoDato.TIPO_TRANSPORTE.getId()).getCadena());

            // Calculo del Tipo de operacion del BL
            final String tipoOperacionBl = null;

            // FIXME Convertir en CR
            blActual.addItdt(TipoDato.TIPO_OP_BL.getId(), calcularTipoOperacionBl(
                    srvc.getItdt(TipoDato.TIPO_MANIF.getId()).getCadena(), modoTransporteEdi.getParametro()));

            break;
        default:
            break;
        }

        return super.visitTdt(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitMea(final MeaContext ctx) {
        switch (ctx.f6311().getText()) {
        case "AAI":
            partActual.addItdt(TipoDato.ENTERO_04.getId(), parseLong(ctx.c174().f6314()));

            break;
        case "VOL":
            partActual.addItdt(TipoDato.DECIMAL_01.getId(), parseDouble(ctx.c174().f6314()));

            break;
        case "WT":
            equiActual.addItdt(TipoDato.ENTERO_02.getId(), parseLong(ctx.c174().f6314()));

            break;
        default:
            break;
        }

        // TODO Auto-generated method stub
        return super.visitMea(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPci(final PciContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PARTIDA_IM.getId());

        paimActual = new SubservicioVO(tpssDetail);

        paimActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        paimActual.setNumero(contador++);

        ssrvList.add(paimActual);
        addSsss(partActual, paimActual);

        paimActual.addItdt(TipoDato.INST_MARC.getId(), getMaestro(Entidad.INSTRUCCION_MARCAJE, ctx.f4233().getText()));
        paimActual.addItdt(TipoDato.CADENA_01.getId(), ctx.c210().f7102(0).getText());

        return super.visitPci(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitDoc(final DocContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PARTIDA_DOCUMENTO.getId());

        padoActual = new SubservicioVO(tpssDetail);

        padoActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        padoActual.setNumero(contador++);

        ssrvList.add(padoActual);
        addSsss(partActual, padoActual);

        padoActual.addItdt(TipoDato.SIT_EMB.getId(), parseString(ctx.c503().f1373(), false));
        padoActual.addItdt(TipoDato.TIPO_DOC_AEAT.getId(),
                getMaestro(Entidad.TIPO_DOCUMENTO_AEAT, ctx.c002().f1001().getText()));
        padoActual.addItdt(TipoDato.CADENA_01.getId(), parseString(ctx.c503().f1004(), true));

        return super.visitDoc(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitSgp(final SgpContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PARTIDA_EQUIPAMIENTO.getId());

        paeqActual = new SubservicioVO(tpssDetail);

        paeqActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        paeqActual.setNumero(contador++);

        ssrvList.add(paeqActual);
        addSsss(partActual, paeqActual);

        final String matricula = ctx.c237().f8260().getText();
        final Long numeroBultos = parseLong(ctx.f7224());

        paeqActual.addItdt(TipoDato.ENTERO_01.getId(), numeroBultos);

        if (!paeqMap.containsKey(matricula)) {
            paeqMap.put(matricula, new ArrayList<SubservicioVO>());
        }

        paeqMap.get(matricula).add(paeqActual);

        return super.visitSgp(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitDgs(final DgsContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PARTIDA_MMPP.getId());

        pampActual = new SubservicioVO(tpssDetail);

        ssrvList.add(pampActual);
        addSsss(partActual, pampActual);

        pampActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        pampActual.setNumero(contador++);

        pampActual.addItdt(TipoDato.MERC_PELIG.getId(),
                getMaestro(Entidad.MERCANCIAS_PELIGROSAS, ctx.c234().f7124().getText() + '-'
                        + ctx.c205().f8351().getText() + '-' + ctx.c205().f8092().getText()));

        return super.visitDgs(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitEqd(final EqdContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.EQUIPAMIENTO.getId());

        elementoActual = ElementoActual.equi;

        equiActual = new SubservicioVO(tpssDetail);

        equiActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        equiActual.setNumero(contador++);
        equiActual.setEstado("R");

        ssrvList.add(equiActual);
        addSsss(blActual, equiActual);

        equiActual.addItdt(TipoDato.COD_EXEN.getId(), "0"); // FIXME Calcular

        final ParametroVO tipoEquipamiento = getMaestro(Entidad.TIPO_EQUIPAMIENTO,
                ctx.f8053().getText() + ctx.c224().f8155().getText());

        equiActual.addItdt(TipoDato.TIPO_EQUI.getId(), tipoEquipamiento);
        equiActual.addItdt(TipoDato.UNIDAD_CARGA.getId(),
                tipoEquipamiento.getItdt(TipoDato.UNIDAD_CARGA.getId()).getPrmt());

        final String matricula = ctx.c237().f8260().getText();

        equiActual.addItdt(TipoDato.CADENA_01.getId(), matricula);

        final String indLlenoVacio = ctx.f8169().getText();

        equiActual.addItdt(TipoDato.CADENA_02.getId(), indLlenoVacio);

        // Hacer que el equipamiento sea padre de los partida-equipamiento
        if (paeqMap.containsKey(matricula)) {
            for (final SubservicioVO paeq : paeqMap.get(matricula)) {
                addSsss(equiActual, paeq);
            }
        }

        switch (indLlenoVacio) {
        case "4":

            break;
        default:
            equiActual.addItdt(TipoDato.ENTERO_01.getId(), 0L);

            // FIXME Asociar con paeq

            break;
        }

        return super.visitEqd(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitEqn(final EqnContext ctx) {
        equiActual.addItdt(TipoDato.ENTERO_01.getId(), parseLong(ctx.c523().f6350()));

        return super.visitEqn(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitSel(final SelContext ctx) {
        final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(Entidad.PRECINTO_EQUIPAMIENTO.getId());

        preqActual = new SubservicioVO(tpssDetail);

        preqActual.setId(new IgBO().nextVal(IgBO.SQ_INTEGRA));
        preqActual.setNumero(contador++);

        ssrvList.add(preqActual);
        addSsss(equiActual, preqActual);

        preqActual.addItdt(TipoDato.CADENA_01.getId(), ctx.f9308().getText());

        return super.visitSel(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitFtx(final FtxContext ctx) {
        switch (ctx.f4451().getText()) {
        case "AAA":
            partActual.addItdt(TipoDato.CADENA_03.getId(), ctx.c108().f4440(0).getText());

            break;
        default:
            break;
        }

        return super.visitFtx(ctx);
    }

    /**
     * Adds the ssss.
     *
     * @param ssrvPadre
     *            the ssrv padre
     * @param ssrvHijo
     *            the ssrv hijo
     */
    private void addSsss(final @NonNull SubservicioVO ssrvPadre, final @NonNull SubservicioVO ssrvHijo) {
        Preconditions.checkNotNull(ssrvPadre.getId());
        Preconditions.checkNotNull(ssrvHijo.getId());

        if (!ssssMap.containsKey(ssrvPadre.getId())) {
            ssssMap.put(ssrvPadre.getId(), new HashSet<Long>());
        }

        ssssMap.get(ssrvPadre.getId()).add(ssrvHijo.getId());
        ssssList.add(new SubservicioSubservicioVO(ssrvPadre.getId(), ssrvHijo.getId()));
    }

    /**
     * Calcular tipo operacion bl.
     *
     * @param tipoManifiesto
     *            the tipo manifiesto
     * @param modoTransporteEdi
     *            the modo transporte edi
     * @return the string
     */
    private String calcularTipoOperacionBl(final @NonNull String tipoManifiesto,
            final @NonNull String modoTransporteEdi) {
        switch (tipoManifiesto) {
        case "DE":
        case "CL":
        case "DL":
        case "SD":
            switch (modoTransporteEdi) {
            case "ZZ1":
            case "ZZ5":
                return "DT";
            case "ZZ2":
            case "ZZ6":
                return "D";
            case "ZZ3":
                return "TD";
            default:
                break;
            }

            break;
        case "CA":
        case "SC":
            switch (modoTransporteEdi) {
            case "ZZ1":
            case "ZZ5":
                return "ET";
            case "ZZ2":
            case "ZZ6":
                return "E";
            case "ZZ3":
                return "TE";

            default:
                break;
            }

            break;
        default:
            break;
        }

        return null;
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
     * Parses the string.
     *
     * @param context
     *            the context
     * @param required
     *            the required
     * @return the string
     */
    private String parseString(final RuleContext context, final boolean required) {
        if (context == null) {
            if (required) {
                throw new Error("String required");
            }

            return null;
        } else {
            return context.getText();
        }
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
     * Parses the integer.
     *
     * @param context
     *            the context
     * @return the integer
     */
    private Integer parseInteger(final RuleContext context) {
        return Integer.parseInt(context.getText());
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
     * @param contextFormat
     *            the context format
     * @return the date
     */
    private Date parseDate(final RuleContext context, final RuleContext contextFormat) {
        try {
            String format;

            switch (contextFormat.getText()) {
            case "201":
                format = "yyMMddHHmm";
                break;
            case "101":
                format = "yyMMdd";
                break;
            default:
                throw new Error("Formato desconocido: " + contextFormat.getText());
            }

            final DateFormat df = new SimpleDateFormat(format);

            return df.parse(context.getText());
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
     * Gets the ssrv map.
     *
     * @return the ssrv map
     */
    public List<SubservicioVO> getSsrvList() {
        return ssrvList;
    }

    /**
     * Gets the ssss map.
     *
     * @return the ssss map
     */
    public Map<Long, Set<Long>> getSsssMap() {
        return ssssMap;
    }

    /**
     * Gets the ssss list.
     *
     * @return the ssss list
     */
    public List<SubservicioSubservicioVO> getSsssList() {
        return ssssList;
    }

    /**
     * Gets the funcion.
     *
     * @return the funcion
     */
    public String getFuncion() {
        return funcion;
    }
}
