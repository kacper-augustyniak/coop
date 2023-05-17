package Steps;

import Pages.BasePage;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxStepDefinition {

    private WebDriver driver = new FirefoxDriver();
    private BasePage basePage = new BasePage(driver);

    @Given ("I am on the {string} page")
    public void I_am_on_the_main_page(String url) {
        basePage.navigateToUrl(url);
    }
    @When ("I click on the \"Elements\" button")
    public void I_click_on_the_Elements_button() {
       basePage.clickElements();
    }
    @Then ("I should see the \"Elements\" page")
    public void I_see_elements_page() {
        basePage.verifyElementsPageUrl();
        basePage.waitForMainHeaderToBeVisible();
    }
    @And ("I should see the \"Text Box\" button")
    public void I_should_see_Text_Box_button() {
        basePage.waitForElementToBeVisible(basePage.getElementsBtn());
    }
    @When ("I click on the \"Text Box\" button")
    public void I_click_on_the_Text_Box_button() {
        basePage.getTextBoxBtn().click();
    }
    @Then ("I should see the \"Text Box\" page")
    public void I_should_see_the_Text_Box_page() {
        basePage.waitForTextBoxPageIsVisible();
    }
    @And ("I should see the {string} text box")
    public void I_should_see_the_text_box(String textBox) {
        basePage.waitForTextBox(textBox);
    }

    @And ("I should see the \"Submit\" button")
    public void I_should_see_the_Submit_button(String btnName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(basePage.getSubmitBtn()));
    }
//    @When ("I will enter the \"Full Name\" as \"Test User\"")
//    public void I_should_see_the_Current_Address_text_box() {

//    }
//    @And ("I will enter the \"Email\" as \"name@example.com\"")
//    @And ("I will enter the \"Current Address\" as \"Test Address\"")
//    @And ("I will enter the \"Permanent Address\" as \"Test Address\"")
//    @And ("I will click on the \"Submit\" button")
//    @Then ("I should see results")
}
