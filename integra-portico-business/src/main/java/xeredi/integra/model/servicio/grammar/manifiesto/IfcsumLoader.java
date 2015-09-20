package xeredi.integra.model.servicio.grammar.manifiesto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import xeredi.edifact.grammar.IfcsumD14bBaseVisitor;
import xeredi.edifact.grammar.IfcsumD14bParser.IfcsumContext;
import xeredi.integra.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumLoader.
 */
public final class IfcsumLoader extends IfcsumD14bBaseVisitor {

    /** The prmts. */
    private Map<Entidad, Set<String>> prmts;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitIfcsum(final IfcsumContext ctx) {
        prmts = new HashMap<Entidad, Set<String>>();

        // TODO Auto-generated method stub
        return super.visitIfcsum(ctx);
    }

}
