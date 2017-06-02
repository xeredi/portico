package xeredi.argo.model.comun.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.ResourceBundle.Control;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.collect.Sets;

import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.dao.MessageI18nDAO;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nCriterioVO;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceBundleService.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class ResourceBundleService extends Control {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ResourceBundleService.class);

	/** The m 18 n DAO. */
	@Inject
	private MessageI18nDAO m18nDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * Load bundle contents.
	 *
	 * @param baseName
	 *            the base name
	 * @param locale
	 *            the locale
	 * @return the object[][]
	 */
	public Object[][] loadBundleContents(final String baseName, final Locale locale) {
		LOG.info("Load Bundle from database for baseName '" + baseName + "' and locale '" + locale + "'");

		final List<Object[]> contentList = new ArrayList<>();
		final String language = locale == null || locale.getLanguage() == null || locale.getLanguage().isEmpty()
				? Locale.getDefault().getLanguage() : locale.getLanguage();

		// Loading from MessageI18nDAO
		final MessageI18nCriterioVO m18nCriterio = new MessageI18nCriterioVO();

		m18nCriterio.setLanguage(language);

		for (final MessageI18nVO m18n : m18nDAO.selectList(m18nCriterio)) {
			contentList.add(new Object[] { m18n.getKey().name(), m18n.getValue() });
		}

		// Loading from I18nDAO
		final I18nCriterioVO i18nCriterio = new I18nCriterioVO();

		i18nCriterio.setPrefixSet(Sets.newHashSet(ClassPrefix.tpdt, ClassPrefix.cdrf, ClassPrefix.enti,
				ClassPrefix.entd, ClassPrefix.engd, ClassPrefix.trmt, ClassPrefix.fncd));
		i18nCriterio.setLanguage(language);

		for (final LabelValueVO labelValue : i18nDAO.selectLabelValueList(i18nCriterio)) {
			contentList.add(new Object[] { labelValue.getLabel(), labelValue.getValue() });
		}

		// ResourceBundle Creation
		final Object[][] contents = new Object[contentList.size()][2];

		for (int i = 0; i < contentList.size(); i++) {
			contents[i] = contentList.get(i);
		}

		LOG.info("Bundle for baseName '" + baseName + "' and locale '" + locale + "' loaded from database");

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceBundle newBundle(final String baseName, final Locale locale, final String format,
			final ClassLoader loader, final boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		return new ArgoResourceBundle(locale, loadBundleContents(baseName, locale));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getFormats(String baseName) {
		return super.getFormats(baseName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Locale> getCandidateLocales(String baseName, Locale locale) {
		return super.getCandidateLocales(baseName, locale);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Locale getFallbackLocale(String baseName, Locale locale) {
		return super.getFallbackLocale(baseName, locale);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getTimeToLive(String baseName, Locale locale) {
		return super.getTimeToLive(baseName, locale);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle,
			long loadTime) {
		return super.needsReload(baseName, locale, format, loader, bundle, loadTime);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toBundleName(String baseName, Locale locale) {
		return super.toBundleName(baseName, locale);
	}
}
