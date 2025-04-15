package test

import com.codeborne.selenide.AuthenticationType
import com.codeborne.selenide.Browser
import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Conditional
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Credentials
import com.codeborne.selenide.DownloadsFolder
import com.codeborne.selenide.Driver
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.LocalStorage
import com.codeborne.selenide.ModalOptions
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideDriver
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.SelenideTargetLocator
import com.codeborne.selenide.SelenideWait
import com.codeborne.selenide.SessionStorage
import com.codeborne.selenide.WebElementCondition
import com.codeborne.selenide.WebElementsCondition
import com.codeborne.selenide.impl.ThreadLocalSelenideDriver
import com.codeborne.selenide.impl.WebDriverContainer
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer
import com.codeborne.selenide.proxy.SelenideProxyServer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.By
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.OutputType
import org.openqa.selenium.Proxy
import org.openqa.selenium.UnhandledAlertException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.SessionId
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.support.events.WebDriverListener

import javax.annotation.CheckReturnValue
import javax.annotation.Nonnull
import javax.annotation.Nullable
import java.awt.datatransfer.Clipboard
import java.util.function.Predicate
import java.util.logging.Level

import static org.junit.jupiter.api.Assertions.assertEquals

abstract class RunTest {


    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1920x1080"
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*")
    }

     static def r() {
        return new RunClass()
    }

    /**===========================================================================
                                    PAGE METHODS
     ===========================================================================**/

    public boolean isAlertPresent() {
        try {
            webDriver.switchTo().alert()
            return true
        }catch (NoAlertPresentException e) {
            return false
        }
    }

    /**===========================================================================
                                    WEB DRIVE RUNNER METHODS
     ===========================================================================**/
    public WebDriverContainer webdriverContainer = WebDriverRunner.webdriverContainer

    void addListener(WebDriverListener listener) {
        WebDriverRunner.addListener(listener)
    }

    void removeListener(WebDriverListener listener) {
        WebDriverRunner.removeListener(listener)
    }

    void setWebDriver(WebDriver webDriver) {
        WebDriverRunner.setWebDriver(webDriver)
    }

    public void setWebDriver(WebDriver webDriver, @Nullable SelenideProxyServer selenideProxy) {
        WebDriverRunner.setWebDriver(webDriver, selenideProxy)
    }

    public void setWebDriver(WebDriver webDriver, @Nullable SelenideProxyServer selenideProxy, DownloadsFolder browserDownloadsFolder) {
        WebDriverRunner.setWebDriver(webDriver, selenideProxy, browserDownloadsFolder)
    }

    @CheckReturnValue
    @Nonnull
    public WebDriver getWebDriver() {
        return WebDriverRunner.getWebDriver()
    }

    public void setProxy(@Nullable Proxy webProxy) {
        WebDriverRunner.setProxy(webProxy)
    }

    @CheckReturnValue
    @Nonnull
    public WebDriver getAndCheckWebDriver() {
        return WebDriverRunner.getAndCheckWebDriver()
    }

    @CheckReturnValue
    @Nonnull
    public SelenideProxyServer getSelenideProxy() {
        return WebDriverRunner.getSelenideProxy()
    }

    @CheckReturnValue
    @Nonnull
    public Driver driver() {
        return WebDriverRunner.driver()
    }

    @CheckReturnValue
    @Nullable
    public DownloadsFolder getBrowserDownloadsFolder() {
        return WebDriverRunner.getBrowserDownloadsFolder()
    }

    @CheckReturnValue
    public boolean hasWebDriverStarted() {
        return WebDriverRunner.hasWebDriverStarted()
    }

    @CheckReturnValue
    public boolean isFirefox() {
        return WebDriverRunner.isFirefox()
    }

    @CheckReturnValue
    public boolean isChrome() {
        return WebDriverRunner.isChrome()
    }

    @CheckReturnValue
    public boolean isIE() {
        return WebDriverRunner.isIE()
    }

    @CheckReturnValue
    public boolean isEdge() {
        return WebDriverRunner.isEdge()
    }

    @CheckReturnValue
    public boolean isHeadless() {
        return WebDriverRunner.isHeadless()
    }

    @CheckReturnValue
    public boolean supportsJavascript() {
        return WebDriverRunner.supportsJavascript()
    }

    public void clearBrowserCache() {
        WebDriverRunner.clearBrowserCache()
    }

    @CheckReturnValue
    @Nonnull
    public String source() {
        return WebDriverRunner.source()
    }

    @CheckReturnValue
    @Nonnull
    public String url() {
        return WebDriverRunner.url()
    }

    @CheckReturnValue
    @Nonnull
    public String currentFrameUrl() {
        return WebDriverRunner.currentFrameUrl()
    }

    /**===========================================================================
                                    SELENIDE METHODS
     ===========================================================================**/
    public void open(String relativeOrAbsoluteUrl) {
        Selenide.open(relativeOrAbsoluteUrl)
    }

    public void open(URL absoluteUrl) {
        Selenide.open(absoluteUrl)
    }

    public void open(String relativeOrAbsoluteUrl, String domain, String login, String password) {
        Selenide.open(relativeOrAbsoluteUrl,domain,login,password)
    }

    public  void open(String relativeOrAbsoluteUrl, AuthenticationType authenticationType, Credentials credentials) {
        Selenide.open(relativeOrAbsoluteUrl, authenticationType, credentials);
    }

    public  void open(URL absoluteUrl, String domain, String login, String password) {
        Selenide.open(absoluteUrl, domain, login, password);
    }

    public  void open() {
        Selenide.open();
    }

    @CheckReturnValue
    @Nonnull
    public  Conditional<WebDriver> webdriver() {
        return Selenide.webdriver();
    }

    public  void using(WebDriver webDriver, Runnable lambda) {
        Selenide.using(webDriver, lambda);
    }

    public  void using(WebDriver webDriver, SelenideProxyServer proxy, Runnable lambda) {
        Selenide.using(webDriver, proxy, lambda);
    }

    public  void inNewBrowser(Runnable lambda) {
        Selenide.inNewBrowser(lambda);
    }

    public  void updateHash(String hash) {
        Selenide.updateHash(hash);
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass> PageObjectClass open(String relativeOrAbsoluteUrl, Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass> PageObjectClass open(URL absoluteUrl, Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(absoluteUrl, pageObjectClassClass);
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass> PageObjectClass open(String relativeOrAbsoluteUrl, String domain, String login, String password, Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(relativeOrAbsoluteUrl, domain, login, password, pageObjectClassClass);
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass> PageObjectClass open(URL absoluteUrl, String domain, String login, String password, Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(absoluteUrl, domain, login, password, pageObjectClassClass);
    }

    public  void closeWindow() {
        Selenide.closeWindow()
    }

    public  void closeWebDriver() {
        Selenide.closeWebDriver()
    }

    public  void refresh() {
        Selenide.refresh();
    }

    public  void back() {
        Selenide.back();
    }

    public  void forward() {
        Selenide.forward();
    }

    @CheckReturnValue
    @Nullable
    public  String title() {
        return Selenide.title();
    }

    public  void sleep(long milliseconds) {
        Selenide.sleep(milliseconds)
    }

    @CheckReturnValue
    @Nullable
    public  String screenshot(String fileName) {
        return Selenide.screenshot(fileName);
    }

    @CheckReturnValue
    @Nullable
    public  <T> T screenshot(OutputType<T> outputType) {
        return Selenide.screenshot(outputType);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $(WebElement webElement) {
        return Selenide.$(webElement);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $(String cssSelector) {
        return Selenide.find(cssSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $x(String xpathExpression) {
        return Selenide.$x(xpathExpression);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $(By seleniumSelector) {
        return Selenide.find(seleniumSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $(By seleniumSelector, int index) {
        return Selenide.find(seleniumSelector, index);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement $(String cssSelector, int index) {
        return Selenide.$(cssSelector, index);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection $$(Collection<? extends WebElement> elements) {
        return Selenide.$$(elements);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection $$(String cssSelector) {
        return Selenide.$$(cssSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection $$x(String xpathExpression) {
        return Selenide.$$x(xpathExpression);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection $$(By seleniumSelector) {
        return Selenide.$$(seleniumSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement element(WebElement webElement) {
        return Selenide.$(webElement);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement element(String cssSelector) {
        return Selenide.$(cssSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement element(By seleniumSelector) {
        return Selenide.$(seleniumSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement element(By seleniumSelector, int index) {
        return Selenide.$(seleniumSelector, index);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideElement element(String cssSelector, int index) {
        return Selenide.$(cssSelector, index);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection elements(Collection<? extends WebElement> elements) {
        return Selenide.$$(elements);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection elements(String cssSelector) {
        return Selenide.$$(cssSelector);
    }

    @CheckReturnValue
    @Nonnull
    public  ElementsCollection elements(By seleniumSelector) {
        return Selenide.$$(seleniumSelector);
    }

    @Nullable
    public  <T> T executeJavaScript(String jsCode, Object... arguments) {
        return Selenide.executeJavaScript(jsCode, arguments);
    }

    @Nullable
    public  <T> T executeAsyncJavaScript(String jsCode, Object... arguments) {
        return Selenide.executeAsyncJavaScript(jsCode, arguments);
    }

    @CheckReturnValue
    @Nullable
    public  SelenideElement getSelectedRadio(By radioField) {
        return Selenide.getSelectedRadio(radioField);
    }

    @Nullable
    public  String confirm() {
        return Selenide.confirm()
    }

    @Nullable
    public  String confirm(@Nullable String expectedDialogText) {
        return Selenide.confirm(expectedDialogText)
    }

    @Nullable
    public  String confirm(ModalOptions options) {
        return Selenide.confirm(options)
    }

    @Nullable
    public  String prompt() {
        return Selenide.prompt()
    }

    @Nullable
    public  String prompt(@Nullable String inputText) {
        return Selenide.prompt(inputText)
    }

    @Nullable
    public  String prompt(@Nullable String expectedDialogText, @Nullable String inputText) {
        return Selenide.prompt(expectedDialogText,inputText)
    }

    @Nullable
    public  String prompt(ModalOptions options, @Nullable String inputText) {
        return Selenide.prompt(options,inputText)
    }

    @Nullable
    public  String dismiss() {
        return Selenide.dismiss()
    }

    @Nullable
    public  String dismiss(@Nullable String expectedDialogText) {
        return Selenide.(expectedDialogText)
    }

    @Nullable
    public  String dismiss(ModalOptions options) {
        return Selenide.dismiss(options)
    }

    public  SelenideTargetLocator switchTo() {
        return Selenide.switchTo()
    }

    @CheckReturnValue
    public  SelenideElement getFocusedElement() {
        return Selenide.getFocusedElement();
    }

    @CheckReturnValue
    @Nonnull
    public  String getSelectedText() {
        return Selenide.getSelectedText();
    }

    public  String copy() {
        return Selenide.copy();
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass> PageObjectClass page(Class<PageObjectClass> pageObjectClass) {
        return Selenide.page(pageObjectClass);
    }

    @CheckReturnValue
    @Nonnull
    @SafeVarargs
    public  <PageObjectClass> PageObjectClass page(PageObjectClass... reified) {
        return Selenide.page(reified);
    }

    @CheckReturnValue
    @Nonnull
    public  <PageObjectClass, T extends PageObjectClass> PageObjectClass page(T pageObject) {
        return Selenide.page(pageObject);
    }

    @CheckReturnValue
    @Nonnull
    public  SelenideWait Wait() {
        return Selenide.Wait();
    }

    @CheckReturnValue
    @Nonnull
    public  Actions actions() {
        return Selenide.actions()
    }

    public  void zoom(double factor) {
        Selenide.zoom(factor);
    }

    @CheckReturnValue
    @Nonnull
    public  List<String> getWebDriverLogs(String logType) {
        return Selenide.getWebDriverLogs(logType)
    }

    @Nonnull
    @CheckReturnValue
    public  List<String> getWebDriverLogs(String logType, Level logLevel) {
        return Selenide.getWebDriverLogs(logType, logLevel)
    }

    public  void clearBrowserCookies() {
        Selenide.clearBrowserCookies()
    }

    public  void clearBrowserLocalStorage() {
        Selenide.clearBrowserLocalStorage()
    }

    @Nonnull
    @CheckReturnValue
    public  String getUserAgent() {
        return Selenide.getUserAgent()
    }

    @CheckReturnValue
    public  boolean atBottom() {
        return Selenide.atBottom();
    }

    @Nonnull
    @CheckReturnValue
    public  File download(String url) throws URISyntaxException {
        return Selenide.download(url)
    }

    @Nonnull
    @CheckReturnValue
    public  File download(URI url) {
        return Selenide.download(url);
    }

    @Nonnull
    @CheckReturnValue
    public  File download(URI url, long timeoutMs) {
        return Selenide.download(url, timeoutMs);
    }

    @Nonnull
    @CheckReturnValue
    public  File download(String url, long timeoutMs) throws URISyntaxException {
        return Selenide.download(url, timeoutMs)
    }

    @Nonnull
    @CheckReturnValue
    public  LocalStorage localStorage() {
        return Selenide.localStorage()
    }

    @Nonnull
    @CheckReturnValue
    public  SessionStorage sessionStorage() {
        return Selenide.sessionStorage()
    }

    @Nonnull
    @CheckReturnValue
    public  Clipboard clipboard() {
        return Selenide.clipboard()
    }

    @Nonnull
    @CheckReturnValue
    public  SessionId sessionId() {
        return Selenide.sessionId()
    }

    /**===========================================================================
                                    CONDITION METHODS
    ===========================================================================**/
    public final WebElementCondition visible = Condition.visible
    public final WebElementCondition exist = Condition.exist
    public final WebElementCondition hidden = Condition.hidden
    public final WebElementCondition appear = Condition.appear
    public final WebElementCondition disappear = Condition.disappear
    public final WebElementCondition interactable = Condition.interactable
    public final WebElementCondition readonly = Condition.readonly
    public final WebElementCondition editable = Condition.editable
    public final WebElementCondition animated = Condition.animated
    public final WebElementCondition empty = Condition.empty
    public final WebElementCondition image = Condition.image
    public final WebElementCondition focused = Condition.focused
    public final WebElementCondition enabled = Condition.enabled
    public final WebElementCondition disabled = Condition.disabled
    public final WebElementCondition selected = Condition.selected
    public final WebElementCondition checked = Condition.checked
    public final WebElementCondition clickable = Condition.clickable

    @CheckReturnValue
    @Nonnull
    public WebElementCondition attribute(String attributeName) {
        return Condition.attribute(attributeName)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition attribute(String attributeName, String expectedAttributeValue) {
        return Condition.attribute(attributeName,expectedAttributeValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition attributeMatching(String attributeName, String attributeRegex) {
        return Condition.attributeMatching(attributeName, attributeRegex)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition href(String href) {
        return Condition.href(href)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition value(String expectedValue) {
        return Condition.value(expectedValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition partialValue(String expectedValue) {
        return Condition.partialValue(expectedValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition pseudo(String pseudoElementName, String propertyName, String expectedValue) {
        return Condition.pseudo(pseudoElementName, propertyName, expectedValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition pseudo(String pseudoElementName, String expectedValue) {
        return Condition.pseudo(pseudoElementName, expectedValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition exactValue(String value) {
        return Condition.exactValue(value)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition name(String name) {
        return Condition.name(name)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition type(String type) {
        return Condition.type(type)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition id(String id) {
        return Condition.id(id)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition matchText(String regex) {
        return Condition.matchText(regex)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition oneOfTexts(String... texts) {
        return Condition.oneOfTexts(texts)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition oneOfTextsCaseSensitive(String... texts) {
        return Condition.oneOfTextsCaseSensitive(texts)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition oneOfExactTexts(String... texts) {
        return Condition.oneOfExactTexts(texts)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition oneOfExactTextsCaseSensitive(String... texts) {
        return Condition.oneOfExactTextsCaseSensitive(texts)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition partialText(String expectedText) {
        return Condition.partialText(expectedText)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition partialTextCaseSensitive(String expectedText) {
        return Condition.partialTextCaseSensitive(expectedText)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition text(String text) {
        return Condition.text(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition selectedText(String expectedText) {
        return Condition.selectedText(expectedText)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition textCaseSensitive(String text) {
        return Condition.textCaseSensitive(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition exactText(String text) {
        return Condition.exactText(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition innerText(String text) {
        return Condition.innerText(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition ownText(String text) {
        return Condition.ownText(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition ownTextCaseSensitive(String text) {
        return Condition.ownTextCaseSensitive(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition exactOwnText(String text) {
        return Condition.exactOwnText(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition exactOwnTextCaseSensitive(String text) {
        return Condition.exactOwnTextCaseSensitive(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition exactTextCaseSensitive(String text) {
        return Condition.exactTextCaseSensitive(text)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition tagName(String cssClass) {
        return Condition.tagName(cssClass)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition cssClass(String cssClass) {
        return Condition.cssClass(cssClass)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition cssValue(String propertyName, @Nullable String expectedValue) {
        return Condition.cssValue(propertyName, expectedValue)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition match(String description, Predicate<WebElement> predicate) {
        return Condition.match(description,predicate)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition not(WebElementCondition condition) {
        return Condition.not(condition)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition and(String name, WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.and(name,condition1, condition2, conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition allOf(String name, WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.allOf(name,condition1,condition2,conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition allOf(WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.allOf(condition1, condition2, conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition or(String name, WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.or(name, condition1, condition2, conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition anyOf(String name, WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.anyOf(name, condition1, condition2, conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition anyOf(WebElementCondition condition1, WebElementCondition condition2, WebElementCondition... conditions) {
        return Condition.anyOf(condition1, condition2, conditions)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition be(WebElementCondition delegate) {
        return Condition.be(delegate)
    }

    @CheckReturnValue
    @Nonnull
    public WebElementCondition have(WebElementCondition delegate) {
        return Condition.have(delegate)
    }

    /**===========================================================================
                            CONDITION COLLECTION METHODS
     ===========================================================================**/

    public WebElementsCondition emptyCollection = CollectionCondition.empty

    @CheckReturnValue
    public WebElementsCondition size(int expectedSize) {
        return CollectionCondition.size(expectedSize)
    }

    @CheckReturnValue
    public WebElementsCondition sizeGreaterThan(int expectedSize) {
        return CollectionCondition.sizeGreaterThan(expectedSize)
    }

    @CheckReturnValue
    public WebElementsCondition sizeGreaterThanOrEqual(int expectedSize) {
        return CollectionCondition.sizeGreaterThanOrEqual(expectedSize)
    }

    @CheckReturnValue
    public WebElementsCondition sizeLessThan(int expectedSize) {
        return CollectionCondition.sizeLessThan(expectedSize)
    }

    @CheckReturnValue
    public WebElementsCondition sizeLessThanOrEqual(int size) {
        return CollectionCondition.sizeLessThanOrEqual(size)
    }

    @CheckReturnValue
    public WebElementsCondition sizeNotEqual(int expectedSize) {
        return CollectionCondition.sizeNotEqual(expectedSize)
    }

    @CheckReturnValue
    public WebElementsCondition texts(String... expectedTexts) {
        return CollectionCondition.texts(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition texts(List<String> expectedTexts) {
        return CollectionCondition.texts(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition textsInAnyOrder(String... expectedTexts) {
        return CollectionCondition.textsInAnyOrder(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition textsInAnyOrder(List<String> expectedTexts) {
        return CollectionCondition.textsInAnyOrder(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition exactTexts(String... expectedTexts) {
        return CollectionCondition.exactTexts(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition exactTexts(List<String> expectedTexts) {
        return CollectionCondition.exactTexts(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition attributes(String attribute, String... expectedValues) {
        return CollectionCondition.attributes(attribute, expectedValues)
    }

    @CheckReturnValue
    public WebElementsCondition attributes(String attribute, List<String> expectedValues) {
        return CollectionCondition.attributes(attribute, expectedValues)
    }

    @CheckReturnValue
    public WebElementsCondition exactTextsCaseSensitive(String... expectedTexts) {
        return CollectionCondition.exactTextsCaseSensitive(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition exactTextsCaseSensitive(List<String> expectedTexts) {
        return CollectionCondition.exactTextsCaseSensitive(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition anyMatch(String description, Predicate<WebElement> predicate) {
        return CollectionCondition.anyMatch(description, predicate)
    }

    @CheckReturnValue
    public WebElementsCondition allMatch(String description, Predicate<WebElement> predicate) {
        return CollectionCondition.allMatch(description, predicate)
    }

    @CheckReturnValue
    public WebElementsCondition noneMatch(String description, Predicate<WebElement> predicate) {
        return CollectionCondition.noneMatch(description, predicate)
    }

    @CheckReturnValue
    public WebElementsCondition itemWithText(String expectedText) {
        return CollectionCondition.itemWithText(expectedText)
    }

    @CheckReturnValue
    public WebElementsCondition containExactTextsCaseSensitive(String... expectedTexts) {
        return CollectionCondition.containExactTextsCaseSensitive(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition containExactTextsCaseSensitive(List<String> expectedTexts) {
        return CollectionCondition.containExactTextsCaseSensitive(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition exactTextsCaseSensitiveInAnyOrder(List<String> expectedTexts) {
        return CollectionCondition.exactTextsCaseSensitiveInAnyOrder(expectedTexts)
    }

    @CheckReturnValue
    public WebElementsCondition exactTextsCaseSensitiveInAnyOrder(String... expectedTexts) {
        return CollectionCondition.exactTextsCaseSensitiveInAnyOrder(expectedTexts)
    }

    /**===========================================================================
                            ASSERT EQUALS METHODS
     ===========================================================================**/

    @CheckReturnValue
    public void assertEquals(int expected, int actual) {
        Assertions.assertEquals(expected, actual)
    }

    @CheckReturnValue
    public void assertEquals(String expected, String actual) {
        Assertions.assertEquals(expected, actual)
    }

    @CheckReturnValue
    public void assertEquals(boolean expected, boolean actual) {
        Assertions.assertEquals(expected, actual)
    }
}

