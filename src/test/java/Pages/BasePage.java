package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String baseUrl = "https://demoqa.com/";
    private String elementsUrl = "https://demoqa.com/elements";
    private String textBoxUrl = "https://demoqa.com/text-box";

    @FindBy (xpath = "(//*[@class='card mt-4 top-card'])[1]")
    private WebElement elementsBtn;
    @FindBy (xpath = "//*[@class='main-header']")
    private WebElement mainHeader;
    @FindBy (xpath = "//*[@id='item-0']//*[contains(text(), 'Text Box')]")
    private WebElement textBoxBtn;
    @FindBy (xpath = "(//*[@class='body-height']//*[contains(text(), 'Text Box')])[1]")
    private WebElement textBoxHeader;
    @FindBy (xpath = "//input[@id=\"userName\"]")
    private WebElement fullName;
    @FindBy (xpath = "//input[@id=\"userEmail\"]")
    private WebElement userEmail;
    @FindBy (xpath = "//input[@id=\"currentAddress\"]")
    private WebElement currentAddress;
    @FindBy (xpath = "//input[@id=\"permanentAddress\"]")
    private WebElement permanentAddress;
    @FindBy (xpath = "//button[@id=\"submit\"]")
    private WebElement submitBtn;
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getElementsUrl() {
        return elementsUrl;
    }

    public String getTextBoxUrl() {
        return textBoxUrl;
    }

    public WebElement getElementsBtn() {
        return elementsBtn;
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public WebElement getTextBoxBtn() {
        return textBoxBtn;
    }

    public WebElement getTextBoxHeader() {
        return textBoxHeader;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void waitForMainHeaderToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getMainHeader()));
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElements() {
        getElementsBtn().click();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void verifyElementsPageUrl() {
        driver.getCurrentUrl().equalsIgnoreCase(elementsUrl);
    }

}
