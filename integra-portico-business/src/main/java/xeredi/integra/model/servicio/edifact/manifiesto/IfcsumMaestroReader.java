package xeredi.integra.model.servicio.edifact.manifiesto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bBaseVisitor;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.BgmContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.CniContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.DgsContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.EqdContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.GidContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.IfcsumContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.LocContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.NadContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.PciContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.RffContext;

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
        addCodigoMaestro(Entidad.MERCANCIAS_PELIGROSAS,
                ctx.c234().f7124().getText() + '-' + ctx.c205().f8351().getText() + '-' + ctx.c205().f8092().getText());

        return super.visitDgs(ctx);
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

    /**
     * Gets the rec aduanero.
     *
     * @return the rec aduanero
     */
    public String getRecAduanero() {
        return recAduanero;
    }

    /**
     * Gets the anio escala.
     *
     * @return the anio escala
     */
    public String getAnioEscala() {
        return anioEscala;
    }

    /**
     * Gets the numero escala.
     *
     * @return the numero escala
     */
    public String getNumeroEscala() {
        return numeroEscala;
    }
}
