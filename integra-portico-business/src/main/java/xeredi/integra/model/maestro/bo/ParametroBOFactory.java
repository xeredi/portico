package xeredi.integra.model.maestro.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ParametroBO objects.
 */
public final class ParametroBOFactory {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ParametroBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class> MAP = new HashMap();

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
        LOG.info("Inicio de la Factoria de ParametroBO");

        for (final TipoParametroVO enti : TipoParametroProxy.selectMap().values()) {
            if (enti.getClasspath() != null) {
                try {
                    final String classname = "xeredi.integra.model.maestro.bo." + enti.getClasspath();

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Carga de la clase " + classname);
                    }

                    MAP.put(enti.getId(), Class.forName(classname));
                } catch (final ClassNotFoundException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }

        LOG.info("Fin de la Factoria de ParametroBO");
    }

    /**
     * New instance.
     *
     * @param entiId
     *            the enti id
     * @return the parametro bo
     */
    public static ParametroBO newInstance(final @Nonnull Long entiId) {
        if (MAP.containsKey(entiId)) {
            try {
                return (ParametroBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        }

        return new DefaultParametroBO();
    }

}
