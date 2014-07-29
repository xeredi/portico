package xeredi.integra.model.util.grammar;

import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.vo.facturacion.ReglaVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PathSqlGenerator.
 */
public final class PathSqlGenerator extends PathBaseVisitor {

    /** The sql. */
    private final transient StringBuffer sql;

    /** The regla. */
    private final transient ReglaVO regla;

    /** The generate label. */
    private final transient boolean generateLabel;

    /** The entidad tmp vo. */
    private EntidadVO entidadTmpVO;

    /** The first path element. */
    private boolean firstPathElement;

    /** The last path element. */
    private boolean lastPathElement;

    /**
     * The Constructor.
     *
     * @param aregla
     *            the aregla
     * @param agenerateLabel
     *            the agenerate label
     */
    public PathSqlGenerator(final ReglaVO aregla, final boolean agenerateLabel) {
        super();

        this.sql = new StringBuffer();
        this.regla = aregla;
        this.generateLabel = agenerateLabel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPath(xeredi.integra.model.util.grammar.PathParser.PathContext ctx) {
        sql.setLength(0);

        entidadTmpVO = regla.getEnti();
        firstPathElement = true;
        lastPathElement = false;

        final Iterator<ParseTree> parseTreeIterator = ctx.children.iterator();

        while (parseTreeIterator.hasNext()) {
            final ParseTree parseTree = parseTreeIterator.next();

            if (!parseTreeIterator.hasNext()) {
                lastPathElement = true;
            }

            parseTree.accept(this);

            firstPathElement = false;
        }

        return sql.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPathElement(xeredi.integra.model.util.grammar.PathParser.PathElementContext ctx) {
        Preconditions.checkNotNull(entidadTmpVO);

        final EntidadVO enti = EntidadProxy.select(entidadTmpVO.getId());
        final StringBuilder sqlElement = new StringBuilder();

        System.out.println("enti: " + enti.getCodigo());

        if (ctx.ELEMENT_SERVICE() != null) {
            if (enti.getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar al servicio desde un subservicio");
            }

            final TipoSubservicioVO tpss = TipoSubservicioProxy.select(enti.getId());

            entidadTmpVO = EntidadProxy.select(tpss.getTpsr().getId());

            sqlElement
                    .append("SELECT ")
                    .append(lastPathElement && generateLabel ? "portico.CONCAT(portico.CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), portico.CONCAT(srvc_anio, portico.CONCAT('/', srvc_numero)))"
                            : "srvc_pk").append(" FROM tbl_servicio_srvc WHERE srvc_pk = ");
            sqlElement.append(firstPathElement ? "item.ssrv_srvc_pk" : "#{any}");
        }
        if (ctx.ELEMENT_PARENT() != null) {
            if (enti.getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar a la entidad padre desde un subservicio");
            }

            entidadTmpVO = EntidadProxy.select(Entidad.valueOf(ctx.ID().getText()).getId());

            sqlElement
                    .append("SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = portico.getEntidad('"
                            + ctx.ID().getText() + "')) AND ssss_ssrvh_pk = ");
            sqlElement.append(firstPathElement ? "item.ssrv_pk" : "ANY(#{any})");
        }
        if (ctx.ELEMENT_DATA() != null) {
            final TipoDato tipoDato = TipoDato.valueOf(ctx.ID().getText());

            Preconditions.checkNotNull(enti);

            final EntidadTipoDatoVO entd = enti.getEntdMap().get(tipoDato.getId());

            Preconditions.checkNotNull(entd);

            switch (entidadTmpVO.getTipo()) {
            case T:
                sqlElement.append("SELECT ");

                switch (entd.getTpdt().getTipoElemento()) {
                case BO:
                case NE:
                    sqlElement.append("srdt_nentero");

                    break;
                case ND:
                    sqlElement.append("srdt_ndecimal");

                    break;
                case FE:
                case FH:
                    sqlElement.append("srdt_fecha");

                    break;
                case TX:
                case CR:
                    sqlElement.append("srdt_cadena");

                    break;
                case PR:
                    sqlElement
                            .append(lastPathElement && generateLabel ? "(SELECT portico.CONCAT(portico.CONCAT(prmt_parametro , ' - '), (SELECT p18n_texto FROM tbl_parametro_i18n_p18n WHERE p18n_idioma = 'es_ES' AND p18n_prvr_pk = ANY(SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref)))) FROM tbl_parametro_prmt WHERE prmt_pk = srdt_prmt_pk)"
                                    : "srdt_prmt_pk");

                    break;
                case SR:
                    sqlElement
                            .append(lastPathElement && generateLabel ? "(SELECT portico.CONCAT(portico.CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), portico.CONCAT(srvc_anio, portico.CONCAT('/', srvc_numero))) FROM tbl_servicio_srvc WHERE srvc_pk = srdt_srvc_dep_pk)"
                                    : "srdt_srvc_dep_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement.append(" FROM tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = portico.getTipoDato('"
                        + ctx.ID().getText() + "') AND srdt_srvc_pk = ");
                sqlElement.append(firstPathElement ? "item.ssrv_srvc_pk" : "ANY(#{any})");

                break;
            case S:
                sqlElement.append("SELECT ");

                switch (entd.getTpdt().getTipoElemento()) {
                case BO:
                case NE:
                    sqlElement.append("ssdt_nentero");

                    break;
                case ND:
                    sqlElement.append("ssdt_ndecimal");

                    break;
                case FE:
                case FH:
                    sqlElement.append("ssdt_fecha");

                    break;
                case TX:
                case CR:
                    sqlElement.append("ssdt_cadena");

                    break;
                case PR:
                    sqlElement
                            .append(lastPathElement && generateLabel ? "(SELECT portico.CONCAT(portico.CONCAT(prmt_parametro , ' - '), (SELECT p18n_texto FROM tbl_parametro_i18n_p18n WHERE p18n_idioma = 'es_ES' AND p18n_prvr_pk = ANY(SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref)))) FROM tbl_parametro_prmt WHERE prmt_pk = ssdt_prmt_pk)"
                                    : "ssdt_prmt_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement.append(" FROM tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = portico.getTipoDato('"
                        + ctx.ID().getText() + "') AND ssdt_ssrv_pk = ");
                sqlElement.append(firstPathElement ? "item.ssrv_pk" : "ANY(#{any})");

                break;
            case P:
                sqlElement.append("SELECT ");

                switch (entd.getTpdt().getTipoElemento()) {
                case BO:
                case NE:
                    sqlElement.append("prdt_nentero");

                    break;
                case ND:
                    sqlElement.append("prdt_ndecimal");

                    break;
                case FE:
                case FH:
                    sqlElement.append("prdt_fecha");

                    break;
                case TX:
                case CR:
                    sqlElement.append("prdt_cadena");

                    break;
                case PR:
                    sqlElement
                            .append(lastPathElement && generateLabel ? "(SELECT portico.CONCAT(portico.CONCAT(prmt_parametro , ' - '), (SELECT p18n_texto FROM tbl_parametro_i18n_p18n WHERE p18n_idioma = 'es_ES' AND p18n_prvr_pk = ANY(SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref)))) FROM tbl_parametro_prmt WHERE prmt_pk = prdt_prmt_pk)"
                                    : "prdt_prmt_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement
                        .append(" FROM tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = portico.getTipoDato('"
                                + ctx.ID().getText()
                                + "') AND prdt_prvr_pk = ANY (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )");

                break;
            default:
                throw new Error("Entidad '" + entidadTmpVO.getTipo() + "' no valida");
            }

            entidadTmpVO = entd.getTpdt().getEnti() == null ? null : EntidadProxy.select(entd.getTpdt().getEnti()
                    .getId());
        }

        if (sql.length() > 0) {
            final int posAny = sqlElement.lastIndexOf("#{any}");

            if (posAny > 0) {
                sqlElement.replace(posAny, posAny + "#{any}".length(), sql.toString());
            } else {
                sqlElement.append(sql);
            }
        }

        sql.setLength(0);
        sql.append(sqlElement);

        return null;
    }
}
