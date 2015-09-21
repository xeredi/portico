package xeredi.argo.model.maestro.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ParametroBO objects.
 */
public final class ParametroBOFactory {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ParametroBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class<?>> MAP = new HashMap<Long, Class<?>>();

    /**
     * Instantiates a new parametro bo factory.
     */
    private ParametroBOFactory() {
        super();
    }

    static {
        load();
    }

    /**
     * Load.
     */
    private static void load() {
        if (LOG.isDebugEnabled()) {
            LOG.info("Factory start");
        }

        for (final TipoParametroDetailVO entiDetail : TipoParametroProxy.selectMap().values()) {
            if (entiDetail.getEnti().getClasspath() != null) {
                try {
                    final String classname = "xeredi.integra.model.maestro.bo." + entiDetail.getEnti().getClasspath();

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Carga de la clase " + classname);
                    }

                    MAP.put(entiDetail.getEnti().getId(), Class.forName(classname));
                } catch (final ClassNotFoundException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }
    }

    /**
     * New instance.
     *
     * @param entiId
     *            the enti id
     * @return the parametro bo
     */
    public static ParametroBO newInstance(final @NonNull Long entiId) {
        if (MAP.containsKey(entiId)) {
            try {
                return (ParametroBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        }

        return new ParametroBO();
    }

    /**
     * New default instance.
     *
     * @return the parametro bo
     */
    public static ParametroBO newDefaultInstance() {
        return new ParametroBO();
    }
}
