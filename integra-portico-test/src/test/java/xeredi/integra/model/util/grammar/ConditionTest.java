package xeredi.integra.model.util.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.vo.facturacion.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConditionTest.
 */
public class ConditionTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ConditionTest.class);

    /**
     * Test.
     *
     * @throws IOException
     *             the IO exception
     */
    @Test
    public void test() throws IOException {
        for (int i = 0; i < 10; i++) {
            test("true");
            test("false");
            test("5 > 2");
            test("5 > 2 AND 2 < 5");
            test("\"2014-12-22\" <> 2.5");
            test("\"2014-12-22 23:57\" <> 2.5");
            test("NOT \"Prueba de Texto\" <> 2.5");
            test("servicio.datoSr(BUQUE) <> 2.5");
            test("padre(BL).padre(MANIFIESTO_CONSIGNATARIO).datoSs(ORGANIZACION) <> servicio.datoSr(BUQUE)");
            test("COALESCE(padre(BL).padre(MANIFIESTO_CONSIGNATARIO).datoSs(ORGANIZACION), servicio.datoSr(BUQUE))");
        }
    }

    /**
     * Test.
     *
     * @param expression
     *            the expression
     * @throws IOException
     *             the IO exception
     */
    private void test(final String expression) throws IOException {
        final String message = "Testing: " + expression;

        System.out.println(message);
        LOG.info(message);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final ConditionLexer lexer = new ConditionLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ConditionParser parser = new ConditionParser(tokens);

        final ParseTree tree = parser.r();

        final ReglaVO reglaVO = new ReglaVO();

        reglaVO.setEnti(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()));

        final ConditionSqlGenerator extractor = new ConditionSqlGenerator(reglaVO);

        extractor.visit(tree);
    }

}
