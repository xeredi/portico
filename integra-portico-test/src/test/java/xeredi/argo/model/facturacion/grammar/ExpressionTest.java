package xeredi.argo.model.facturacion.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpressionTest.
 */
public final class ExpressionTest {
    /**
     * Test.
     *
     * @throws IOException
     *             the IO exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Test
    public void test() throws IOException, InstanceNotFoundException {
        for (int i = 0; i < 1; i++) {
            test(Entidad.PARTIDA.getId(), "0.456", PathType.ID);
            test(Entidad.PARTIDA.getId(), "-0.4 + 2 * 3 * (4 + 1)", PathType.ID);
            test(Entidad.PARTIDA.getId(), "3 >= 2 + 1", PathType.ID);
            test(Entidad.PARTIDA.getId(), "2 BETWEEN 1 AND 3", PathType.ID);
            test(Entidad.PARTIDA.getId(), "3 > 2 AND 2 < 3", PathType.ID);
            test(Entidad.PARTIDA.getId(), "(3 > 2) OR (2 < 3)", PathType.ID);
            test(Entidad.PARTIDA.getId(), "COALESCE(2, 3) + 5", PathType.ID);
            test(Entidad.PARTIDA.getId(), "CONCAT('Hola', 3) + 5", PathType.ID);
            test(Entidad.PARTIDA.getId(), "3 IS NULL OR 4 IS NOT NULL AND 'x' = ANY ('a', 'b')", PathType.ID);
        }
    }

    /**
     * Test.
     *
     * @param entiId the enti id
     * @param expression            the expression
     * @param generateLabel            the generate label
     * @throws IOException             the IO exception
     * @throws InstanceNotFoundException             the instance not found exception
     */
    private void test(final Long entiId, final String expression, final PathType pathType) throws IOException,
            InstanceNotFoundException {
        final String message = "Testing: " + expression;

        System.out.println(message);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final ExpressionLexer lexer = new ExpressionLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ExpressionParser parser = new ExpressionParser(tokens);
        final ParseTree tree = parser.expression();

        final ExpressionSqlGenerator extractor = new ExpressionSqlGenerator(entiId,
                pathType);

        extractor.visit(tree);

        System.out.println("resultado: " + extractor.visit(tree));
    }

}
