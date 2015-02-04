package xeredi.integra.model.servicio.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SubservicioBO objects.
 */
public final class SubservicioBOFactory {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SubservicioBOFactory.class);

    /** The Constant MAP. */
    private static final Map<Long, Class> MAP = new HashMap();

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
    private static void load() {
        LOG.info("Inicio de la Factoria de SubservicioBO");

        for (final TipoSubservicioVO enti : TipoSubservicioProxy.selectMap().values()) {
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

        LOG.info("Fin de la Factoria de SubservicioBO");
    }

    /**
     * New instance.
     *
     * @param entiId
     *            the enti id
     * @return the subservicio bo
     */
    public static SubservicioBO newInstance(final Long entiId) {
        Preconditions.checkNotNull(entiId);

        if (MAP.containsKey(entiId)) {
            try {
                return (SubservicioBO) MAP.get(entiId).newInstance();
            } catch (final IllegalAccessException ex) {
                throw new Error(ex);
            } catch (final InstantiationException ex) {
                throw new Error(ex);
            }
        }

        return new DefaultSubservicioBO();
    }

}
