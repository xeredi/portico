package xeredi.argo.model.servicio.bo;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
    private static final void load() {
        if (LOG.isDebugEnabled()) {
            LOG.info("Factory start");
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
     * @param entiId            the enti id
     * @return the servicio bo
     */
    public static final ServicioBO newInstance(final @NonNull Long entiId/*, final @NonNull Long usroId*/) {
        ServicioBO srvcBO = null;

        if (MAP.containsKey(entiId)) {
            try {
                srvcBO = (ServicioBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        } else {
            srvcBO = new ServicioBO();
        }

        // srvcBO.setUsroId(usroId);

        return srvcBO;
    }

    /**
     * New default instance.
     *
     * @return the servicio BO
     */
    public static final ServicioBO newDefaultInstance(/*final @NonNull Long usroId*/) {
        final ServicioBO srvcBO = new ServicioBO();

        // srvcBO.setUsroId(usroId);

        return srvcBO;
    }
}
