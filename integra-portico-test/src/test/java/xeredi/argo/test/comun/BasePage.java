package xeredi.argo.test.comun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
public abstract class BasePage {

    /** The web driver. */
    protected WebDriver webDriver;

    /** The main menu. */
    @FindBy(css = "a[translate='menu']")
    private WebElement mainMenu;

    /** The administracion menu. */
    @FindBy(css = "a[ng-href*='#/administracion']")
    private WebElement administracionMenu;

    /** The error list. */
    @FindBy(css = "span[translate='errorList']")
    private WebElement errorList;

    /** The show filter button. */
    @FindBy(css = "button[data-ng-click=\"vm.filter('lg')\"]")
    private WebElement showFilterButton;

    /** The hide filter button. */
    @FindBy(css = "button[data-ng-click='$hide()']")
    private WebElement hideFilterButton;

    /** The filter button. */
    @FindBy(css = "button[data-ng-click='vm.search(1);$hide()']")
    private WebElement searchButton;

    /** The remove button. */
    @FindBy(css = "button[data-ng-click='vm.remove()']")
    private WebElement removeButton;

    /** The cancel button. */
    @FindBy(css = "button[data-ng-click='vm.cancel()']")
    private WebElement cancelButton;

    /** The save button. */
    @FindBy(css = "button[data-ng-click='vm.save()']")
    private WebElement saveButton;

    /** The i18n text. */
    @FindBy(css = "input[ng-model='vm.i18nMap[default_language].text']")
    private WebElement i18nText;

    /**
     * Instantiates a new base page.
     *
     * @param awebDriver
     *            the aweb driver
     */
    public BasePage(final WebDriver awebDriver) {
        super();

        webDriver = awebDriver;
        webDriver.manage().window().maximize();

        PageFactory.initElements(webDriver, this);
        waitForAngular();
    }

    protected void waitForAngular() {
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) webDriver).executeAsyncScript("var callback = arguments[arguments.length - 1];"
                + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
    }

    /**
     * Main menu open.
     *
     * @return the base page
     */
    public final BasePage mainMenuOpen() {
        mainMenu.click();

        return this;
    }

    /**
     * Administracion menu.
     *
     * @return the base page
     */
    public final BasePage administracionMenu() {
        mainMenu.click();
        administracionMenu.click();

        return this;
    }

    /**
     * Show filter.
     *
     * @return the base page
     */
    public final BasePage showFilter() {
        showFilterButton.click();

        return this;
    }

    /**
     * Hide filter.
     *
     * @return the base page
     */
    public final BasePage hideFilter() {
        hideFilterButton.click();

        return this;
    }

    /**
     * Filter.
     *
     * @return the base page
     */
    public final BasePage search() {
        searchButton.click();

        return this;
    }

    /**
     * Removes the.
     *
     * @return the base page
     */
    public final BasePage remove() {
        removeButton.click();

        return this;
    }

    /**
     * Cancel.
     *
     * @return the base page
     */
    public final BasePage cancel() {
        cancelButton.click();

        return this;
    }

    /**
     * Save.
     *
     * @return the base page
     */
    public final BasePage save() {
        saveButton.click();

        return this;
    }

    /**
     * Sets the i18n text.
     *
     * @param value
     *            the value
     * @return the base page
     */
    public final BasePage setI18nText(final String value) {
        setInputText(i18nText, value);

        return this;
    }

    /**
     * Confirm ok.
     *
     * @return the fluent page
     */
    public final BasePage confirmOk() {
        webDriver.switchTo().alert().accept();

        return this;
    }

    /**
     * Confirm cancel.
     *
     * @return the fluent page
     */
    public final BasePage confirmCancel() {
        webDriver.switchTo().alert().dismiss();

        return this;
    }

    /**
     * Back.
     *
     * @return the base page
     */
    public final BasePage back() {
        webDriver.navigate().back();

        return this;
    }

    /**
     * Checks for errors.
     *
     * @return true, if successful
     */
    public final boolean hasErrors() {
        return errorList.isDisplayed();
    }

    /**
     * Sets the input text.
     *
     * @param element
     *            the element
     * @param value
     *            the value
     */
    protected final void setInputText(final WebElement element, final String value) {
        element.clear();

        if (value != null) {
            element.sendKeys(value);
        }
    }

    protected final void selectValue(final WebElement element, final String value) {
        if (value != null) {
            new Select(element).selectByValue("string:" + value);
        }
    }
}
