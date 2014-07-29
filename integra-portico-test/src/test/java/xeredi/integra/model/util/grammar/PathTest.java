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
 * The Class PathTest.
 */
public final class PathTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PathTest.class);

    /**
     * Test.
     *
     * @throws IOException
     *             the IO exception
     */
    @Test
    public void test() throws IOException {
        for (int i = 0; i < 1; i++) {
            test("servicio.dato(ACUERDO)");
            test("dato(MERCANCIA)");
            test("padre(BL).dato(COD_EXEN)");
            test("padre(BL).dato(UNLOCODE).dato(PAIS)");
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
        final PathLexer lexer = new PathLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokens);

        final ParseTree tree = parser.value();

        final ReglaVO reglaVO = new ReglaVO();

        reglaVO.setEnti(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()));

        final PathSqlGenerator extractor = new PathSqlGenerator(reglaVO, true);

        LOG.info(extractor.visit(tree));
    }

}
