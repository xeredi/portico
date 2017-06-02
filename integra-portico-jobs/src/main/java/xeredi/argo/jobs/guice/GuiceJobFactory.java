package xeredi.argo.jobs.guice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lombok.NonNull;
import xeredi.argo.model.util.ArgoGuiceModule;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating GuiceJob objects.
 */
public class GuiceJobFactory implements JobFactory {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(GuiceJobFactory.class);

	/** The guice. */
	private static final Injector injector = Guice.createInjector(new ArgoGuiceModule());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Job newJob(final @NonNull TriggerFiredBundle bundle, final @NonNull Scheduler scheduler)
			throws SchedulerException {
		final JobDetail jobDetail = bundle.getJobDetail();
		final Class jobClass = jobDetail.getJobClass();

		try {
			return (Job) injector.getInstance(jobClass);
		} catch (Exception ex) {
			LOG.fatal(ex.getMessage(), ex);

			throw new UnsupportedOperationException(ex);
		}
	}
}
