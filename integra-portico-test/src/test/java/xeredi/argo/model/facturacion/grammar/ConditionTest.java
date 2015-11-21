package xeredi.argo.model.facturacion.grammar;

import java.io.IOException;
import java.util.Calendar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ReglaVersionVO;
import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class Test2Test.
 */
public final class ConditionTest {

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Test
    public void test() throws IOException, InstanceNotFoundException {
        // test("5 > 3");
        test("true");
        test("(true)");
        test("(true AND false) OR (NOT true)");
        test("(true OR false) AND (5 > 4)");
        test("NOT (COALESCE(3, 5) > 4)");
        test("escalaEsAvituallamiento() AND (5 > 4)");
        test("escalaEsBuqueCertificado('PEPE') AND (escalaNumeroPuertosBuque() > escalaValorContador('PEPITO'))");
        test("dato(MERCANCIA) = 5");
        test("servicio.dato(TIPO_MANIF) = 5");
        test("padre(BL).dato(TIPO_OP_BL) = 5");
        test("servicio.dato(TIPO_MANIF) = 'P'");
        // test("servicio.dato(BUQUE) <> 4");
    }

    /**
     * Test.
     *
     * @param expression
     *            the expression
     * @throws IOException
     *             the IO exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    private void test(final String expression) throws IOException, InstanceNotFoundException {
        System.out.println("Testing: " + expression);

        final ANTLRInputStream input = new ANTLRInputStream(expression);
        final ConditionLexer lexer = new ConditionLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ConditionParser parser = new ConditionParser(tokens);
        final ParseTree tree = parser.condition();

        final ValoradorContextoVO contextoVO = new ValoradorContextoVO();
        final ReglaVO reglaVO = new ReglaVO();

        reglaVO.setVersion(new ReglaVersionVO());
        reglaVO.setEnti(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()).getEnti());
        contextoVO.setRgla(reglaVO);
        contextoVO.setFref(Calendar.getInstance().getTime());

        final ConditionSqlGenerator extractor = new ConditionSqlGenerator(reglaVO);

        System.out.println("resultado: " + extractor.visit(tree));
    }

}