package xeredi.integra.model.servicio.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ServicioBO objects.
 */
public final class ServicioBOFactory {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class> MAP = new HashMap();

    /**
     * Instantiates a new servicio bo factory.
     */
    private ServicioBOFactory() {
        super();
    }

    static {
        load();
    }

    /**
     * Load.
     */
    private static void load() {
        LOG.info("Inicio de la Factoria de ServicioBO");

        for (final TipoServicioVO enti : TipoServicioProxy.selectMap().values()) {
            if (enti.getClasspath() != null) {
                try {
                    final String classname = "xeredi.integra.model.servicio.bo." + enti.getClasspath();

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Carga de la clase " + classname);
                    }

                    MAP.put(enti.getId(), Class.forName(classname));
                } catch (final ClassNotFoundException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }

        LOG.info("Fin de la Factoria de ServicioBO");
    }

    /**
     * New instance.
     *
     * @param entiId
     *            the enti id
     * @return the servicio bo
     */
    public static ServicioBO newInstance(final Long entiId) {
        Preconditions.checkNotNull(entiId);

        if (MAP.containsKey(entiId)) {
            try {
                return (ServicioBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        }

        return new DefaultServicioBO();
    }
}
