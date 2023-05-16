package Steps;

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

    @Given("I am on the \"https://demoqa.com/\" page")
    public void I_navigate_to_main_page() {
        driver.get("https://demoqa.com/");
    }

    @When ("I click on the \"Elements\" button")
    public void I_click_on_the_Elements() {
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[1]")).click();
    }
    @Then ("I should see the \"Elements\" page")
    public void I_see_elements_page() {
        driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/elements");
        driver.findElement(By.xpath("//*[@class='main-header']")).isDisplayed();
    }
    @And ("I should see the \"Text Box\" button")
    public void I_should_see_Text_Box_button() {
        WebElement textbox = driver.findElement(By.xpath("//*[@id='item-0']//*[contains(text(), 'Text Box')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(textbox));
    }
    @When ("I click on the \"Text Box\" button")
    public void I_click_on_the_Text_Box_button() {
        driver.findElement(By.xpath("//*[@id='item-0']//*[contains(text(), 'Text Box')]")).click();
    }
    Then I should see the "Text Box" page
    And I should see the "Full Name" text box
    And I should see the "Email" text box
    And I should see the "Current Address" text box
    And I should see the "Permanent Address" text box
    And I should see the "Submit" button
    When I will enter the "Full Name" as "Test User"
    And I will enter the "Email" as "name@example.com"
    And I will enter the "Current Address" as "Test Address"
    And I will enter the "Permanent Address" as "Test Address"
    And I will click on the "Submit" button
    Then I should see results
}
