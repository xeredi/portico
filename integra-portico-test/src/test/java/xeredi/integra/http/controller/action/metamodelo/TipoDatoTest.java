package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoTest.
 */
public final class TipoDatoTest extends StrutsTestCase {

    /**
     * Test grid.
     *
     * @throws Exception
     *             the exception
     */
    public void testGrid() throws Exception {
        {
            request.clearAttributes();
            request.addParameter("tpdtCriterio.codigo", "A%");

            final ActionProxy proxy = getActionProxy("/metamodelo/tipo-dato-list.action");
            final TipoDatoListAction action = (TipoDatoListAction) proxy.getAction();

            assertEquals(Action.SUCCESS, proxy.execute(), Action.SUCCESS);
            assertTrue("No Errors", action.getActionErrors().isEmpty());
            assertFalse("Data", action.getResultList().getList().isEmpty());
            assertEquals("First Page", action.getPage(), 1);
        }

        {
            request.clearAttributes();
            request.addParameter("page", "20");

            final ActionProxy proxy = getActionProxy("/metamodelo/tipo-dato-list.action");
            final TipoDatoListAction action = (TipoDatoListAction) proxy.getAction();

            assertEquals(Action.SUCCESS, proxy.execute(), Action.SUCCESS);
            assertTrue("No Errors", action.getActionErrors().isEmpty());
            assertTrue("No Data", action.getResultList().getList().isEmpty());
        }

        {
            request.clearAttributes();

            final ActionProxy proxy = getActionProxy("/metamodelo/tipo-dato-edit.action");
            final TipoDatoEditAction action = (TipoDatoEditAction) proxy.getAction();

            assertEquals(Action.SUCCESS, proxy.execute(), Action.SUCCESS);
            assertTrue("No Errors", action.getActionErrors().isEmpty());
        }
    }
}
