package xeredi.argo.model.servicio.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ServicioBO objects.
 */
public final class ServicioBOFactory {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class<?>> MAP = new HashMap<Long, Class<?>>();

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
        if (LOG.isDebugEnabled()) {
            LOG.debug("Factory start");
        }

        for (final TipoServicioDetailVO entiDetail : TipoServicioProxy.selectMap().values()) {
            if (entiDetail.getEnti().getClasspath() != null) {
                try {
                    final String classname = "xeredi.integra.model.servicio.bo." + entiDetail.getEnti().getClasspath();

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
     * @param usroId
     *            the usro id
     * @return the servicio bo
     */
    public static ServicioBO newInstance(@NonNull final Long entiId, @NonNull final Long usroId) {
        try {
            return MAP.containsKey(entiId) ? (ServicioBO) MAP.get(entiId).getDeclaredConstructor(Long.class, Long.class)
                    .newInstance(entiId, usroId) : new ServicioBO(entiId, usroId);
        } catch (final Throwable ex) {
            throw new Error(ex);
        }
    }
}
