package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Getter

public class BasePage {

    private WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String baseUrl = "https://demoqa.com/";
    private String elementsUrl = "https://demoqa.com/elements";
    private String textBoxUrl = "https://demoqa.com/text-box";

    @FindAll({
            @FindBy(how = How.CSS, using = "div.element-group")
    })
    private List<WebElement> leftMenuElements;
    @FindBy(how = How.CSS, using = "ul.menu-list li#item-1")
    private WebElement elementButton;

    @FindBy (how = How.XPATH, using = "//*[@class='card mt-4 top-card']")
    private WebElement elementsBtn;
    @FindBy (xpath = "//*[@class='main-header']")
    private WebElement mainHeader;

    @FindBy (xpath = "(//*[contains(text(), 'Elements')])[2]")
    private WebElement elementsHeader;
    @FindBy (xpath = "//*[@id='item-0']//*[contains(text(), 'Text Box')]")
    private WebElement textBoxBtn;
    @FindBy (xpath = "(//*[@class='body-height']//*[contains(text(), 'Text Box')])[1]")
    private WebElement textBoxHeader;
    @FindBy (xpath = "//*[@id=\"userName\"]")
    private WebElement fullName;
    @FindBy (xpath = "//*[@id=\"userEmail\"]")
    private WebElement userEmail;
    @FindBy (xpath = "//*[@id=\"currentAddress\"]")
    private WebElement currentAddress;
    @FindBy (xpath = "//*[@id=\"permanentAddress\"]")
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
        wait.until(ExpectedConditions.visibilityOf(mainHeader));
    }

    public void waitUntilPageIsVisible(String header) {

        if (header.equals("Text Box")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getTextBoxHeader()));
        } else if (header.equals("Elements")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(getElementsHeader()));
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

    public void waitForButton(String btnName) {
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

}
