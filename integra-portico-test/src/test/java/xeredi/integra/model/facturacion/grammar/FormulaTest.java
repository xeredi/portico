package xeredi.integra.model.facturacion.grammar;

import java.io.IOException;
import java.util.Calendar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.facturacion.vo.ValoradorContextoVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.util.grammar.FormulaLexer;
import xeredi.integra.model.util.grammar.FormulaParser;

// TODO: Auto-generated Javadoc
/**
 * The Class FormulaTest.
 */
public final class FormulaTest {

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    public void test() throws IOException {
        // test("5 > 3");
        test("5");
        test("(4.3)");
        test("(4.3 + 5) * (3 - 2)");
        test("(COALESCE(3, 5) + 4)");
        test("dato(MERCANCIA) + 1");
        test("servicio.dato(TIPO_MANIF) * 5");
        test("padre(BL).dato(TIPO_OP_BL) / 5");
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
        System.out.println("Testing: " + expression);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final FormulaLexer lexer = new FormulaLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final FormulaParser parser = new FormulaParser(tokens);
        final ParseTree tree = parser.formula();

        final ValoradorContextoVO contextoVO = new ValoradorContextoVO();
        final ReglaVO reglaVO = new ReglaVO();

        reglaVO.setRglv(new ReglaVersionVO());
        reglaVO.getRglv().setEnti(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()));
        contextoVO.setRgla(reglaVO);
        contextoVO.setFref(Calendar.getInstance().getTime());

        final FormulaSqlGenerator extractor = new FormulaSqlGenerator(reglaVO);

        System.out.println("resultado: " + extractor.visit(tree));
    }

}
