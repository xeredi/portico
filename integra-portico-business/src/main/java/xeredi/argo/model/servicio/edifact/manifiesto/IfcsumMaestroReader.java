package xeredi.argo.model.servicio.edifact.manifiesto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoCriterioVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.edifact.grammar.IfcsumD14bBaseVisitor;
import xeredi.edifact.grammar.IfcsumD14bParser.BgmContext;
import xeredi.edifact.grammar.IfcsumD14bParser.CniContext;
import xeredi.edifact.grammar.IfcsumD14bParser.DgsContext;
import xeredi.edifact.grammar.IfcsumD14bParser.DocContext;
import xeredi.edifact.grammar.IfcsumD14bParser.EqdContext;
import xeredi.edifact.grammar.IfcsumD14bParser.GidContext;
import xeredi.edifact.grammar.IfcsumD14bParser.IfcsumContext;
import xeredi.edifact.grammar.IfcsumD14bParser.LocContext;
import xeredi.edifact.grammar.IfcsumD14bParser.NadContext;
import xeredi.edifact.grammar.IfcsumD14bParser.PciContext;
import xeredi.edifact.grammar.IfcsumD14bParser.RffContext;
import xeredi.edifact.grammar.IfcsumD14bParser.TdtContext;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumMaestroReader.
 */
public final class IfcsumMaestroReader extends IfcsumD14bBaseVisitor {

    /** The maestro codes map. */
    private final Map<Entidad, Set<String>> maestroCodesMap = new HashMap<>();

    /** The nif set. */
    private final Set<String> nifSet = new HashSet<>();

    /** The rec aduanero. */
    private String recAduanero;

    /** The anio escala. */
    private String anioEscala;

    /** The numero escala. */
    private String numeroEscala;

    /** The prto. */
    private PuertoVO prto;

    /** The escala. */
    private ServicioVO escala;

    /** The prmt map. */
    private final Map<Entidad, Map<String, ParametroVO>> prmtMap = new HashMap<>();

    /** The nif map. */
    private final Map<String, ParametroVO> nifMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitIfcsum(final IfcsumContext ctx) {

        return super.visitIfcsum(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitBgm(final BgmContext ctx) {
        final String numeroDocumento = ctx.c106().f1004().getText();

        recAduanero = numeroDocumento.substring(0, 4);
        anioEscala = "201" + numeroDocumento.substring(4, 5);
        numeroEscala = numeroDocumento.substring(6);

        return super.visitBgm(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitLoc(final LocContext ctx) {
        switch (ctx.f3227().getText()) {
        case "92":
        case "61":
        case "5":
        case "9":
        case "11":
        case "8":
        case "13":
            addCodigoMaestro(Entidad.UNLOCODE, ctx.c517().f3225().getText());

            break;
        case "14":
            addCodigoMaestro(Entidad.ALINEACION, ctx.c517().f3225().getText());

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
    public Object visitNad(final NadContext ctx) {
        switch (ctx.f3035().getText()) {
        case "CV":
        case "CN":
            nifSet.add(ctx.c082().f3039().getText().substring(2));

            break;
        case "TR":
            nifSet.add(ctx.c082().f3039().getText());

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
    public Object visitRff(final RffContext ctx) {
        switch (ctx.c506().f1153().getText()) {
        case "ZTC":
            addCodigoMaestro(Entidad.TERMINAL, ctx.c506().f1154().getText());
            addCodigoMaestro(Entidad.INSTALACION_ESPECIAL, ctx.c506().f1154().getText());

            break;
        case "ZBC":
            addCodigoMaestro(Entidad.ACUERDO, ctx.c506().f1154().getText());

            break;
        case "ZLS":
            addCodigoMaestro(Entidad.SERVICIO_TRAFICO, ctx.c506().f1154().getText());

            break;
        case "ABD":
            addCodigoMaestro(Entidad.MERCANCIA, ctx.c506().f1154().getText());

            break;
        case "ZMV":
            addCodigoMaestro(Entidad.MARCA_VEHICULO, ctx.c506().f1154().getText());

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
    public Object visitCni(final CniContext ctx) {

        // TODO Auto-generated method stub
        return super.visitCni(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitGid(final GidContext ctx) {
        addCodigoMaestro(Entidad.TIPO_BULTO, ctx.c213(0).f7065().getText());

        return super.visitGid(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPci(final PciContext ctx) {
        addCodigoMaestro(Entidad.INSTRUCCION_MARCAJE, ctx.f4233().getText());

        return super.visitPci(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitDgs(final DgsContext ctx) {
        addCodigoMaestro(Entidad.MERCANCIAS_PELIGROSAS, ctx.c234().f7124().getText() + '-'
                + ctx.c205().f8351().getText() + '-' + ctx.c205().f8092().getText());

        return super.visitDgs(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitDoc(final DocContext ctx) {
        addCodigoMaestro(Entidad.TIPO_DOCUMENTO_AEAT, ctx.c002().f1001().getText());

        return super.visitDoc(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitEqd(final EqdContext ctx) {
        addCodigoMaestro(Entidad.TIPO_EQUIPAMIENTO, ctx.f8053().getText() + ctx.c224().f8155().getText());

        return super.visitEqd(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitTdt(final TdtContext ctx) {
        switch (ctx.f8051().getText()) {
        case "10":
        case "30":
            addCodigoMaestro(Entidad.MODO_TRANSPORTE_EDI, ctx.c220().f8067().getText());

            break;
        default:
            break;
        }

        return super.visitTdt(ctx);
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
     * Buscar dependencias.
     *
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void buscarDependencias() throws InstanceNotFoundException {
        // Busqueda del puerto
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setRecAduanero(recAduanero);

        prto = prtoBO.selectObject(prtoCriterio);

        addCodigoMaestro(Entidad.UNLOCODE, prto.getUnlocode());

        // Busqueda de la escala
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(Entidad.MANIFIESTO.getId());
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        prtoCriterio.setId(prto.getId());

        srvcCriterio.setEntiId(Entidad.MANIFIESTO.getId());
        srvcCriterio.setPrto(prtoCriterio);
        srvcCriterio.setAnno(anioEscala);
        srvcCriterio.setNumero(numeroEscala);

        escala = srvcBO.selectObject(srvcCriterio);
        final Date fref = escala.getFref(); // FIXME

        // Maestros
        for (final Entidad entidad : maestroCodesMap.keySet()) {
            prmtMap.put(entidad, new HashMap<String, ParametroVO>());

            final ParametroBO prmtBO = ParametroBOFactory.newInstance(entidad.getId());
            final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

            if (TipoParametroProxy.select(entidad.getId()).getEnti().getPuerto()) {
                prmtCriterio.setPrto(prtoCriterio);
            }

            prmtCriterio.setEntiId(entidad.getId());
            prmtCriterio.setFechaVigencia(fref);
            prmtCriterio.setParametros(maestroCodesMap.get(entidad));

            for (final ParametroVO prmt : prmtBO.selectList(prmtCriterio)) {
                prmtMap.get(entidad).put(prmt.getParametro(), prmt);
            }
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
        final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setFechaVigencia(fref);
        prmtCriterio.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());

        final ItemDatoCriterioVO itdtCriterio = new ItemDatoCriterioVO();

        itdtCriterio.setTpdtId(TipoDato.CADENA_02.getId());
        itdtCriterio.setCadenas(nifSet);

        prmtCriterio.setEntiId(Entidad.ORGANIZACION.getId());
        prmtCriterio.getItdtMap().put(TipoDato.CADENA_02.getId(), itdtCriterio);

        for (final ParametroVO prmt : prmtBO.selectList(prmtCriterio)) {
            nifMap.put(prmt.getItdt(TipoDato.CADENA_02.getId()).getCadena(), prmt);
        }
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Gets the escala.
     *
     * @return the escala
     */
    public ServicioVO getEscala() {
        return escala;
    }

    /**
     * Gets the prmt map.
     *
     * @return the prmt map
     */
    public Map<Entidad, Map<String, ParametroVO>> getPrmtMap() {
        return prmtMap;
    }

    /**
     * Gets the nif map.
     *
     * @return the nif map
     */
    public Map<String, ParametroVO> getNifMap() {
        return nifMap;
    }
}
