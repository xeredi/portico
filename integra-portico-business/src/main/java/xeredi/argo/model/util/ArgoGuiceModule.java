package xeredi.argo.model.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.guice.XMLMyBatisModule;

// TODO: Auto-generated Javadoc
/**
 * The Class ArgoGuiceModule.
 */
public final class ArgoGuiceModule extends XMLMyBatisModule {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ArgoGuiceModule.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		LOG.info("Initialising ArgoGuiceModule");

		setClassPathResource("mybatis-config.xml");
	}
}
