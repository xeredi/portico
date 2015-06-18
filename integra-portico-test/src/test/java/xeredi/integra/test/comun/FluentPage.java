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
 * The Class FluentPage.
 */
public abstract class FluentPage {

    /** The driver. */
    protected final WebDriver webDriver;

    /** The fluent web driver. */
    protected final FluentWebDriver fluentWebDriver;

    /**
     * Instantiates a new fluent page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public FluentPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        webDriver = awebDriver;
        fluentWebDriver = afluentWebDriver;

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
     * Sets the input.
     *
     * @param cssSelector
     *            the css selector
     * @param value
     *            the value
     * @return the fluent web element
     */
    protected final FluentWebElement setInput(final String cssSelector, final String value) {
        final FluentWebElement element = input(cssSelector);

        element.clearField();

        if (value != null) {
            element.sendKeys(value);
        }

        return element;
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
     * Select value.
     *
     * @param cssSelector
     *            the css selector
     * @param value
     *            the value
     * @return the fluent select
     */
    protected final FluentSelect selectValue(final String cssSelector, final String value) {
        final FluentSelect select = select(cssSelector);

        if (value != null) {
            select.selectByValue(value);
        }

        return select;
    }

    /**
     * Click save.
     *
     * @return the fluent page
     */
    public final FluentPage clickSave() {
        button("vm.save()").click();

        return this;
    }

    /**
     * Click cancel.
     *
     * @return the fluent page
     */
    public final FluentPage clickCancel() {
        button("vm.cancel()").click();

        return this;
    }

    /**
     * Checks for errors.
     *
     * @return true, if successful
     */
    public final boolean hasErrors() {
        return span("span[translate='errorList']").isDisplayed().value();
    }

    /**
     * Sets the i18n.
     *
     * @param language
     *            the language
     * @param text
     *            the text
     * @return the tipo dato edit page
     */
    public final FluentPage setI18n(final String language, final String text) {
        setInput("vm.i18nMap[default_language].text", text);

        return this;
    }

    /**
     * Sets the i18n.
     *
     * @param text
     *            the text
     * @return the tipo dato edit page
     */
    public final FluentPage setI18n(final String text) {
        setI18n("default_language", text);

        return this;
    }

    /**
     * Click open filter.
     *
     * @return the tipo dato grid page
     */
    public final FluentPage clickOpenFilter() {
        button("vm.filter('lg')").click();

        return this;
    }

    /**
     * Click close filter.
     *
     * @return the tipo dato grid page
     */
    public final FluentPage clickCloseFilter() {
        button("$hide()").click();

        return this;
    }

    /**
     * Click filter.
     *
     * @return the tipo dato grid page
     */
    public final FluentPage clickFilter() {
        button("vm.search(1);$hide()").click();

        return this;
    }

    /**
     * Click delete.
     *
     * @return the fluent page
     */
    public final FluentPage clickDelete() {
        button("vm.remove()").click();

        return this;
    }

    /**
     * Confirm ok.
     *
     * @return the fluent page
     */
    public final FluentPage confirmOk() {
        webDriver.switchTo().alert().accept();

        return this;
    }

    /**
     * Confirm cancel.
     *
     * @return the fluent page
     */
    public final FluentPage confirmCancel() {
        webDriver.switchTo().alert().dismiss();

        return this;
    }

    /**
     * Back.
     */
    public final void back() {
        webDriver.navigate().back();
    }

    /**
     * Administracion menu.
     */
    public final void administracionMenu() {
        link("a[translate='menu']").click();
        linkHref("#/administracion").click();
    }

}
