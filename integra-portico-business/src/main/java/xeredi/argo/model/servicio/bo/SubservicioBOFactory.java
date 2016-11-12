package xeredi.argo.model.servicio.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SubservicioBO objects.
 */
public final class SubservicioBOFactory {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SubservicioBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class<?>> MAP = new HashMap<Long, Class<?>>();

    /**
     * Instantiates a new subservicio bo factory.
     */
    private SubservicioBOFactory() {
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

        for (final TipoSubservicioDetailVO entiDetail : TipoSubservicioProxy.selectMap().values()) {
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
     * @return the subservicio bo
     */
    public static final SubservicioBO newInstance(final @NonNull Long entiId, final @NonNull Long usroId) {
        try {
            return MAP.containsKey(entiId) ? (SubservicioBO) MAP.get(entiId)
                    .getDeclaredConstructor(Long.class, Long.class).newInstance(entiId, usroId)
                    : new SubservicioBO(entiId, usroId);
        } catch (final Throwable ex) {
            throw new Error(ex);
        }
    }
}
