package xeredi.argo.proceso.servicio.edifact.escala;

import java.io.IOException;

import org.junit.Test;

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
