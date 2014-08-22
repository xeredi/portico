package xeredi.integra.model.comun.bo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating BO objects.
 */
public final class BOFactory {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(BOFactory.class);

    /** The Constant INJECTOR. */
    private static final Injector INJECTOR = createInjector();

    /**
     * Creates a new BO object.
     *
     * @return the injector
     */
    private static Injector createInjector() {
        LOG.info("Configuracion Guice");

        final Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("local");
                setClassPathResource("mybatis-config.xml");
            }
        });

        LOG.info("Configuracion Guice OK");

        return injector;
    }

    /**
     * Gets the injector.
     *
     * @return the injector
     */
    public static Injector getInjector() {
        return INJECTOR;
    }

    /**
     * Gets the bo.
     *
     * @param type
     *            the type
     * @return the bo
     */
    public static T getBO(final Class<? extends T> type) {
        return INJECTOR.getInstance(type);
    }

}
