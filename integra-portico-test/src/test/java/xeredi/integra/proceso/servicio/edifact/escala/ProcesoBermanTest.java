package xeredi.integra.proceso.servicio.edifact.escala;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import xeredi.integra.model.servicio.edifact.escala.BermanMaestroReader;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bLexer;
import xeredi.integra.model.servicio.grammar.escala.BermanD14bParser;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoBermanTest.
 */
public final class ProcesoBermanTest {
	/**
	 * Test.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws IOException {
		final ProcesoBerman berman = new ProcesoBerman();

		for (int i = 0; i < 1; i++) {
			berman.parse("/berman.data");
		}

		System.out.println("Ok!");
	}

}
