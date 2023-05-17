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

    @FindBy (xpath = "(//*[contains(text(), 'Elements')])[2]")
    private WebElement elementsHeader;
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

    @FindBy (xpath = "//*[@id='output']")
    private WebElement output;
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getElementsUrl() {
        return elementsUrl;
    }
    public WebElement getElementsHeader() {
        return elementsHeader;
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

    public WebElement getOutput() {
        return output;
    }

    public void waitForMainHeaderToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getMainHeader()));
    }

    public void waitUntilPageIsVisible(WebElement header) {
        if (header.equals("Text Box")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(textBoxHeader));
        } else if (header.equals("Elements")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(elementsHeader));
        }

    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.getCurrentUrl().equalsIgnoreCase(textBoxUrl);
    }

    public void click(String btnName) {
        if (btnName.equals("Text Box")) {
            getTextBoxBtn().click();
        } else if (btnName.equals("Elements")) {
            getElementsBtn().click();
        } else if (btnName.equals("Submit")) {
            getSubmitBtn().click();
        }
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void verifyElementsPageUrl() {
        driver.getCurrentUrl().equalsIgnoreCase(elementsUrl);
    }

    public void waitForTextBox(String textBox) {
        if (textBox.equalsIgnoreCase("Full Name")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getFullName()));
        } else if (textBox.equalsIgnoreCase("Email Address")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getUserEmail()));
        } else if (textBox.equalsIgnoreCase("Current Address")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getCurrentAddress()));
        } else if (textBox.equalsIgnoreCase("Permanent Address")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getPermanentAddress()));
        }
    }

    public void waitForButton(WebElement btnName) {
        if (btnName.equals("Submit")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(submitBtn));
        } else if (btnName.equals("Text Box")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(textBoxBtn));
        }
    }

    public void enterValue(String element, String input) {
        if (element.equals("Full Name")) {
            getFullName().clear();
            getFullName().sendKeys(input);
        } else if (element.equals("Email")) {
            getUserEmail().clear();
            getUserEmail().sendKeys(input);
        } else if (element.equals("Current Address")) {
            getCurrentAddress().clear();
            getCurrentAddress().sendKeys(input);
        } else if (element.equals("Permanent Address")) {
            getPermanentAddress().clear();
            getPermanentAddress().sendKeys(input);
        }


    }

    public boolean readOutput() {
        return getOutput().isDisplayed();
    }
}
