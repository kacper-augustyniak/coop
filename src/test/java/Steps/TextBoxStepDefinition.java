package Steps;

import Pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TextBoxStepDefinition {

    private WebDriver driver = new ChromeDriver();
    private BasePage basePage = new BasePage(driver);

    @Given("I am on the {string} page")
    public void I_am_on_the_main_page(String url) {
        basePage.navigateToUrl(url);
        basePage.getOutput().click();
        List leftMenuList = basePage.getLeftMenuElements();
        for (int i = 0; i < leftMenuList.size(); i++) {
            System.out.println(leftMenuList.get(i).toString());
            if (leftMenuList.get(i).toString().contains("Elements")) {
                basePage.getElementButton().click();
                break;
            }
        }
    }

    @When("I click on the {string} button")
    public void I_click_on_the_button(String btnName) {
        basePage.click(btnName);
    }

    @Then("I should see the {string} page")
    public void I_should_see_the_page(String headerName) {
        basePage.getElementsBtn().click();
        basePage.waitUntilPageIsVisible(headerName);
    }

    @And("I should see the {string} text box")
    public void I_should_see_the_text_box(String textBox) {
        basePage.waitForTextBox(textBox);
    }

    @And("I should see the {string} button")
    public void I_should_see_the_button(String btnName) {
        basePage.waitForButton(btnName);
    }

    @When("I will enter the {string} as {string}")
    public void I_will_enter_input_to_field(String element, String value) {
        basePage.enterValue(element, value);
    }
//    @Then ("I should see results")
//    public void I_should_see_output() {
//        assertTrue(basePage.readOutput());
//    }
}
