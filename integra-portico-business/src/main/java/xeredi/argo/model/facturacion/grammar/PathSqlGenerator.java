package xeredi.argo.model.facturacion.grammar;

import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import xeredi.argo.model.facturacion.grammar.PathParser.PropertyContext;
import xeredi.argo.model.facturacion.grammar.PathParser.PropertyElementContext;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PathSqlGenerator.
 */
public final class PathSqlGenerator extends PathBaseVisitor {

    /** The sql. */
    private final transient StringBuffer sql;

    /** The regla. */
    private final transient AbstractEntidadDetailVO entiDetailBase;

    /** The generate label. */
    private final transient boolean generateLabel;

    /** The entidad tmp vo. */
    private AbstractEntidadDetailVO entiDetailTmp;

    /** The first path element. */
    private boolean firstPathElement;

    /** The last path element. */
    private boolean lastPathElement;

    /**
     * The Constructor.
     *
     * @param aentiDetailBase
     *            the aenti detail base
     * @param agenerateLabel
     *            the agenerate label
     */
    public PathSqlGenerator(final AbstractEntidadDetailVO aentiDetailBase, final boolean agenerateLabel) {
        super();

        sql = new StringBuffer();
        entiDetailBase = aentiDetailBase;
        generateLabel = agenerateLabel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitProperty(final PropertyContext ctx) {
        sql.setLength(0);

        entiDetailTmp = entiDetailBase;
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
    public Object visitPropertyElement(final PropertyElementContext ctx) {
        Preconditions.checkNotNull(entiDetailTmp);

        final AbstractEntidadDetailVO entiDetail = EntidadProxy.select(entiDetailTmp.getEnti().getId());
        final StringBuilder sqlElement = new StringBuilder();

        if (ctx.ELEMENT_SERVICE() != null) {
            if (entiDetail.getEnti().getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar al servicio desde un subservicio");
            }

            final TipoSubservicioDetailVO tpssDetail = TipoSubservicioProxy.select(entiDetail.getEnti().getId());

            entiDetailTmp = EntidadProxy.select(tpssDetail.getEnti().getTpsrId());

            sqlElement
            .append("SELECT ")
            .append(lastPathElement && generateLabel ? "CONCAT(CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), CONCAT(srvc_anio, CONCAT('/', srvc_numero)))"
                    : "srvc_pk").append(" FROM tbl_servicio_srvc WHERE srvc_pk = ");
            sqlElement.append(firstPathElement ? "item.ssrv_srvc_pk" : "#{any}");
        }
        if (ctx.ELEMENT_PARENT() != null) {
            if (entiDetail.getEnti().getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar a la entidad padre desde un subservicio");
            }

            entiDetailTmp = EntidadProxy.select(Entidad.valueOf(ctx.ID().getText()).getId());

            sqlElement
            .append("SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = portico.getEntidad('"
                    + ctx.ID().getText() + "')) AND ssss_ssrvh_pk = ");
            sqlElement.append(firstPathElement ? "item.ssrv_pk" : "(#{any})");
        }
        if (ctx.ELEMENT_DATA() != null) {
            final TipoDato tipoDato = TipoDato.valueOf(ctx.ID().getText());

            Preconditions.checkNotNull(entiDetail);

            EntidadTipoDatoVO entd = null;

            for (final Long tpdtId : entiDetail.getEntdList()) {
                final EntidadTipoDatoVO vo = entiDetail.getEntdMap().get(tpdtId);

                if (vo.getTpdt().getId() == tipoDato.getId()) {
                    entd = vo;
                }
            }

            if (entd == null) {
                throw new Error("Dato no encontrado: " + tipoDato);
            }

            Preconditions.checkNotNull(entd);

            switch (entiDetailTmp.getEnti().getTipo()) {
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
                    .append(lastPathElement && generateLabel ? "(SELECT CONCAT(CONCAT(prmt_parametro , ' - '), COALESCE((SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref='prvr' AND i18n_lang = 'es' AND i18n_ext_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref))), 'NO i18n!!!')) FROM tbl_parametro_prmt WHERE prmt_pk = srdt_prmt_pk)"
                            : "srdt_prmt_pk");

                    break;
                case SR:
                    sqlElement
                    .append(lastPathElement && generateLabel ? "(SELECT CONCAT(CONCAT(( SELECT prmt_parametro FROM tbl_parametro WHERE prmt_pk = srvc_subp_pk ), '/'), CONCAT(srvc_anio, CONCAT('/', srvc_numero))) FROM tbl_servicio_srvc WHERE srvc_pk = srdt_srvc_dep_pk)"
                            : "srdt_srvc_dep_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement.append(" FROM tbl_servicio_dato_srdt WHERE srdt_tpdt_pk = portico.getTipoDato('"
                        + ctx.ID().getText() + "') AND srdt_srvc_pk = ");
                sqlElement
                        .append(firstPathElement ? entiDetailBase.getEnti().getTipo() == TipoEntidad.T ? "item.srvc_pk"
                                : "item.ssrv_srvc_pk" : "(#{any})");

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
                    .append(lastPathElement && generateLabel ? "(SELECT CONCAT(CONCAT(prmt_parametro , ' - '), COALESCE((SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref='prvr' AND i18n_lang = 'es' AND i18n_ext_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref))), 'NO i18n!!!')) FROM tbl_parametro_prmt WHERE prmt_pk = ssdt_prmt_pk)"
                            : "ssdt_prmt_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement.append(" FROM tbl_subservicio_dato_ssdt WHERE ssdt_tpdt_pk = portico.getTipoDato('"
                        + ctx.ID().getText() + "') AND ssdt_ssrv_pk = ");
                sqlElement.append(firstPathElement ? "item.ssrv_pk" : "(#{any})");

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
                    .append(lastPathElement && generateLabel ? "(SELECT CONCAT(CONCAT(prmt_parametro , ' - '), COALESCE((SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref='prvr' AND i18n_lang = 'es' AND i18n_ext_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = prmt_pk AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref))), 'NO i18n!!!')) FROM tbl_parametro_prmt WHERE prmt_pk = prdt_prmt_pk)"
                            : "prdt_prmt_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                sqlElement
                .append(" FROM tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = portico.getTipoDato('"
                        + ctx.ID().getText()
                        + "') AND prdt_prvr_pk = (SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref) AND prvr_prmt_pk = ANY(#{any}) )");

                break;
            default:
                throw new Error("Entidad '" + entiDetailTmp.getEnti().getTipo() + "' no valida");
            }

            entiDetailTmp = entd.getTpdt().getEnti() == null ? null : EntidadProxy.select(entd.getTpdt().getEnti()
                    .getId());
        }

        if (sqlElement.length() > 0) {
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

    public StringBuffer getSql() {
        return sql;
    }
}
