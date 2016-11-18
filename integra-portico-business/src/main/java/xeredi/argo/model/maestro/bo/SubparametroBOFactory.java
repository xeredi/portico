package xeredi.argo.model.maestro.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SubparametroBO objects.
 */
public final class SubparametroBOFactory {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SubparametroBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class<?>> MAP = new HashMap<Long, Class<?>>();

    /**
     * Instantiates a new subparametro bo factory.
     */
    private SubparametroBOFactory() {
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

        for (final TipoSubparametroDetailVO entiDetail : TipoSubparametroProxy.selectMap().values()) {
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
     * @return the subparametro bo
     */
    public static SubparametroBO newInstance(@NonNull final Long entiId) {
        if (MAP.containsKey(entiId)) {
            try {
                return (SubparametroBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        }

        return new SubparametroBO();
    }

    /**
     * New default instance.
     *
     * @return the subparametro bo
     */
    public static SubparametroBO newDefaultInstance() {
        return new SubparametroBO();
    }

}
