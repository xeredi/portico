package xeredi.integra.http.controller.action.estadistica;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoExportActionTest.
 */
public final class PeriodoProcesoExportActionTest extends StrutsTestCase {

    /**
     * Test export.
     */
    public void testExport() {
        try {
            request.clearAttributes();
            request.addParameter("pepr.id", "2433252");

            final ActionProxy proxy = getActionProxy("/estadistica/pepr-export.action");
            final PeriodoProcesoExportAction action = (PeriodoProcesoExportAction) proxy.getAction();

            assertEquals(Action.SUCCESS, proxy.execute(), Action.SUCCESS);
            assertTrue("No Errors", action.getActionErrors().isEmpty());
        } catch (final Throwable ex) {
            ex.printStackTrace(System.err);
        }
    }
}
