package xeredi.integra.test.comun;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.selenium.fluent.FluentBy;
import org.seleniumhq.selenium.fluent.FluentSelect;
import org.seleniumhq.selenium.fluent.FluentWebDriver;
import org.seleniumhq.selenium.fluent.FluentWebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AngularJsTest.
 */
public abstract class AngularJsTest {

    /** The driver. */
    protected final WebDriver webDriver;

    /** The fluent web driver. */
    protected final FluentWebDriver fluentWebDriver;

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
    }

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
                ((JavascriptExecutor) driver)
                .executeAsyncScript("var callback = arguments[arguments.length - 1];"
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
