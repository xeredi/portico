package xeredi.integra.model.util.grammar;

import org.antlr.v4.runtime.tree.ParseTree;

import com.google.common.base.Preconditions;

import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.vo.facturacion.ReglaVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoEntidad;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PathSqlGenerator.
 */
public final class PathSqlGenerator extends PathBaseVisitor {

    /** The sql. */
    private final transient StringBuffer sql;

    /** The regla. */
    private final transient ReglaVO regla;

    /** The entidad tmp vo. */
    private EntidadVO entidadTmpVO;

    /**
     * The Constructor.
     *
     * @param aregla
     *            the aregla
     */
    public PathSqlGenerator(final ReglaVO aregla) {
        super();

        this.sql = new StringBuffer();
        this.regla = aregla;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPath(xeredi.integra.model.util.grammar.PathParser.PathContext ctx) {
        sql.setLength(0);

        entidadTmpVO = regla.getEnti();

        for (final ParseTree parseTree : ctx.children) {
            parseTree.accept(this);
        }

        System.out.println("sql: " + sql);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitPathElement(xeredi.integra.model.util.grammar.PathParser.PathElementContext ctx) {
        Preconditions.checkNotNull(entidadTmpVO);

        final EntidadVO enti = EntidadProxy.select(entidadTmpVO.getId());

        if (ctx.ELEMENT_SERVICE() != null) {
            if (enti.getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar al servicio desde un subservicio");
            }

            final TipoSubservicioVO tpss = TipoSubservicioProxy.select(enti.getId());

            entidadTmpVO = EntidadProxy.select(tpss.getTpsr().getId());

            sql.append("SELECT ssrv_srvc_pk FROM tbl_subservicio_ssrv");
        }
        if (ctx.ELEMENT_PARENT() != null) {
            if (enti.getTipo() != TipoEntidad.S) {
                throw new Error("Solo se puede llegar a la entidad padre desde un subservicio");
            }

            final TipoSubservicioVO tpss = TipoSubservicioProxy.select(enti.getId());

            entidadTmpVO = EntidadProxy.select(tpss.getTpsr().getId());

            sql.append("SELECT ssss_ssrvp_pk FROM tbl_subser_subserv_ssss WHERE EXISTS (SELECT 1 FROM tbl_subservicio_ssrv WHERE ssrv_pk = ssss_ssrvp_pk AND ssrv_tpss_pk = portico.getTipoDato('"
                    + ctx.ID().getText() + "')) AND ssss_ssrvh_pk = ANY(");
        }
        if (ctx.ELEMENT_DATA() != null) {
            final TipoDato tipoDato = TipoDato.valueOf(ctx.ID().getText());

            Preconditions.checkNotNull(enti);

            final EntidadTipoDatoVO entd = enti.getEntdMap().get(tipoDato.getId());

            Preconditions.checkNotNull(entd);

            entidadTmpVO = entd.getEntiId() == null ? null : EntidadProxy.select(entd.getEntiId());

            switch (entidadTmpVO.getTipo()) {
            case T:
                sql.append("SELECT srdt_");

                switch (entd.getTpdt().getTipoElemento()) {
                case BO:
                case NE:
                    sql.append("nentero");

                    break;
                case ND:
                    sql.append("ndecimal");

                    break;
                case FE:
                case FH:
                    sql.append("fecha");

                    break;
                case TX:
                case CR:
                    sql.append("cadena");

                    break;
                case PR:
                    sql.append("prmt_pk");

                    break;
                default:
                    throw new Error("Tipo de dato '" + entd.getTpdt().getTipoElemento() + "' no valido");
                }

                break;
            default:
                break;
            }

            sql.append("Dato!!_" + ctx.ID().getText());
        }

        return null;
    }
}
