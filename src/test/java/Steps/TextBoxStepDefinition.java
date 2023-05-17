package Steps;

import Pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;


public class TextBoxStepDefinition {

    private WebDriver driver = new FirefoxDriver();
    private BasePage basePage = new BasePage(driver);

    @Given ("I am on the {string} page")
    public void I_am_on_the_main_page(String url) {
        basePage.navigateToUrl(url);
    }
    @When ("I click on the {string} button")
    public void I_click_on_the_Elements_button(String btnName) {
       basePage.click(btnName);
    }
    @Then ("I should see the {string} page")
    public void I_should_see_the_page(WebElement header) {
        basePage.waitUntilPageIsVisible(header);
    }
    @And ("I should see the {string} text box")
    public void I_should_see_the_text_box(String textBox) {
        basePage.waitForTextBox(textBox);
    }
    @And ("I should see the {string} button")
    public void I_should_see_the_button(WebElement btnName) {
        basePage.waitForButton(btnName);
    }
    @When ("I will enter the {string} as {string}")
    public void I_will_enter_input_to_field(String element, String value) {
        basePage.enterValue(element, value);
    }
    @Then ("I should see results")
    public void I_should_see_output() {
        assertTrue(basePage.readOutput());
    }
}
