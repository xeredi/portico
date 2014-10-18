package xeredi.integra.model.metamodelo.proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class MetamodeloProxy.
 */
public final class MetamodeloProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MetamodeloProxy.class);

    /**
     * Reload.
     */
    public static void reload() {
        LOG.info("Metamodelo Reload");

        try {
            TipoDatoProxy.load();
            EntidadProxy.load();
            TipoParametroProxy.load();
            TipoSubparametroProxy.load();
            TipoServicioProxy.load();
            TipoSubservicioProxy.load();
            TipoEstadisticaProxy.load();

            LOG.info("Metamodelo Reload success");
        } catch (final Throwable ex) {
            LOG.fatal("Metamodelo reload error", ex);

            throw ex;
        }
    }

}
