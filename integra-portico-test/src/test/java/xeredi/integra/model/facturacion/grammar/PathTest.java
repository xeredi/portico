package xeredi.integra.model.facturacion.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.grammar.PathLexer;
import xeredi.integra.model.util.grammar.PathParser;

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
            test("0.4", false);
            test("'ABC'", false);
            test("servicio.dato(ACUERDO)", true);
            test("servicio.dato(ACUERDO)", false);
            test("dato(MERCANCIA)", true);
            test("dato(MERCANCIA)", false);
            test("padre(BL).dato(COD_EXEN)", true);
            test("padre(BL).dato(COD_EXEN)", false);
            test("padre(BL).dato(UNLOCODE).dato(PAIS)", true);
            test("padre(BL).dato(UNLOCODE).dato(PAIS)", false);
        }
    }

    /**
     * Test.
     *
     * @param expression
     *            the expression
     * @param generateLabel
     *            the generate label
     * @throws IOException
     *             the IO exception
     */
    private void test(final String expression, final boolean generateLabel) throws IOException {
        final String message = "Testing: " + expression;

        System.out.println(message);
        LOG.info(message);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final PathLexer lexer = new PathLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokens);
        final ParseTree tree = parser.value();

        final ReglaVO reglaVO = new ReglaVO();

        reglaVO.setRglv(new ReglaVersionVO());
        reglaVO.getRglv().setEnti(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()));

        final PathSqlGenerator extractor = new PathSqlGenerator(reglaVO.getRglv().getEnti(), generateLabel);

        LOG.info(extractor.visit(tree));
    }

}
