package xeredi.integra.proceso.servicio.manifiesto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bBaseVisitor;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bLexer;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.IfcsumContext;
import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumD14bParser.UntContext;

public final class IfcsumTest extends IfcsumD14bBaseVisitor {

	/**
	 * {@inheritDoc}
	 */
    @Override
	public Object visitIfcsum(IfcsumContext ctx) {
    	System.out.println("IFCSUM!!!");

		return super.visitIfcsum(ctx);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object visitUnt(UntContext ctx) {
    	System.out.println("UNT!!!");

    	return super.visitUnt(ctx);
	}

	private void parse(final String filename) throws IOException {
        try (final InputStream is = new FileInputStream(filename)) {
            final ANTLRInputStream input = new ANTLRInputStream(is);
            final IfcsumD14bLexer lexer = new IfcsumD14bLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final IfcsumD14bParser parser = new IfcsumD14bParser(tokens);
            final ParseTree tree = parser.ifcsum();

            visit(tree);
        }
    }

    @Test
    public void test() throws IOException {
        parse("/ifcsum.data");
    }

}
