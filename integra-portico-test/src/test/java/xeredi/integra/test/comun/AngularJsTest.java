package xeredi.integra.test.comun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.selenium.fluent.FluentBy;
import org.seleniumhq.selenium.fluent.FluentSelect;
import org.seleniumhq.selenium.fluent.FluentWebDriver;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;

// TODO: Auto-generated Javadoc
/**
 * The Class AngularJsTest.
 */
public abstract class AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AngularJsTest.class);

    /** The driver. */
    protected final WebDriver webDriver;

    /** The fluent web driver. */
    protected final FluentWebDriver fluentWebDriver;

    /** The idioma. */
    protected String idioma;

    /** The date format. */
    protected DateFormat dateFormat;

    /** The datetime format. */
    protected DateFormat datetimeFormat;

    /** The time format. */
    protected DateFormat timeFormat;

    /**
     * Instantiates a new angular js test.
     *
     * @param awebDriver
     *            the aweb driver
     */
    public AngularJsTest(final WebDriver awebDriver) {
        super();

        webDriver = awebDriver;
        fluentWebDriver = new FluentWebDriver(webDriver);

        webDriver.manage().window().maximize();

        idioma = ConfigurationProxy.getString(ConfigurationKey.language_default);

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        datetimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        timeFormat = new SimpleDateFormat("HH:mm");
    }

    /**
     * Test.
     */
    @Test
    public final void test() {
        LOG.info("Test Start");

        try {
            doPrepare();
            doTest();
        } catch (final ApplicationException ex) {
            LOG.error(ex, ex);

            Assert.fail(ex.getMessage());
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);

            Assert.fail(ex.getMessage());
        }

        LOG.info("Test End");
    }

    /**
     * Do prepare.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected void doPrepare() throws ApplicationException {
        // noop
    }

    /**
     * Do test.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected abstract void doTest() throws ApplicationException;

    /**
     * Ng wait.
     *
     * @param by
     *            the by
     * @return the by
     */
    public static By ngWait(final By by) {
        return new FluentBy() {
            @Override
            public void beforeFindElement(final WebDriver driver) {
                driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
                ((JavascriptExecutor) driver).executeAsyncScript("var callback = arguments[arguments.length - 1];"
                        + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
                super.beforeFindElement(driver);
            }

            @Override
            public List<WebElement> findElements(final SearchContext context) {
                return by.findElements(context);
            }

            @Override
            public WebElement findElement(final SearchContext context) {
                return by.findElement(context);
            }
        };
    }

    /**
     * Back.
     */
    protected final void back() {
        webDriver.navigate().back();
    }

    /**
     * Link.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement link(final String cssSelector) {
        return fluentWebDriver.link(ngWait(By.cssSelector(cssSelector)));
    }

    /**
     * Link href.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement linkHref(final String cssSelector) {
        return fluentWebDriver.link(ngWait(By.cssSelector("a[ng-href*=\"" + cssSelector + "\"]")));
    }

    /**
     * Button.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement button(final String cssSelector) {
        return fluentWebDriver.button(ngWait(By.cssSelector("button[data-ng-click=\"" + cssSelector + "\"]")));
    }

    /**
     * P.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement p(final String cssSelector) {
        return fluentWebDriver.p(ngWait(By.cssSelector("p[ng-bind=\"" + cssSelector + "\"]")));
    }

    /**
     * Li.
     *
     * @param index
     *            the index
     * @return the fluent web element
     */
    protected final FluentWebElement linkTab(final String index) {
        return fluentWebDriver.link(ngWait(By.cssSelector("a[data-index=\"" + index + "\"]")));
    }

    /**
     * Span.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement span(final String cssSelector) {
        return fluentWebDriver.span(ngWait(By.cssSelector(cssSelector)));
    }

    /**
     * Input.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent web element
     */
    protected final FluentWebElement input(final String cssSelector) {
        return fluentWebDriver.input(ngWait(By.cssSelector("input[ng-model=\"" + cssSelector + "\"]")));
    }

    /**
     * Select.
     *
     * @param cssSelector
     *            the css selector
     * @return the fluent select
     */
    protected final FluentSelect select(final String cssSelector) {
        return fluentWebDriver.select(ngWait(By.cssSelector("select[ng-model=\"" + cssSelector + "\"]")));
    }

    /**
     * Login.
     *
     * @param login
     *            the login
     * @param contrasenia
     *            the contrasenia
     */
    protected final void login(final String login, final String contrasenia) {
        webDriver.get("http://127.0.0.1:8080/web");

        input("vm.usro.login").sendKeys(login);
        input("vm.usro.contrasenia").sendKeys(contrasenia);

        button("vm.acceso()").click();
    }

    /**
     * Main menu.
     */
    protected final void mainMenu() {
        link("a[translate='menu']").click();
    }

}
