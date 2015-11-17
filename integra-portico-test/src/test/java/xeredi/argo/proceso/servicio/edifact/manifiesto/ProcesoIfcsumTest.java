package xeredi.argo.proceso.servicio.edifact.manifiesto;

import java.io.IOException;

import org.junit.Test;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoIfcsumTest.
 */
public final class ProcesoIfcsumTest {

    /**
     * Test.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Test
    public void test() throws IOException, InstanceNotFoundException, DuplicateInstanceException {
        final ProcesoIfcsum ifcsum = new ProcesoIfcsum();

        for (int i = 0; i < 1; i++) {
            ifcsum.parse("/ifcsum.data");
        }

        System.out.println("Ok!");
    }
}
