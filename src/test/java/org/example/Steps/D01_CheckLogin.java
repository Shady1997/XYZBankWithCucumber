package org.example.Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.example.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class D01_CheckLogin extends TestBase{
    // define page objects
    private P01_HomePage loginPage;
    private WebDriver testDriver;

    // Step1 : Start driver and navigate to target url
    @Given("Start driver and navigate to target url {string}")
    public void startDriverAndNavigateToTargetUrl(String arg0) {
        // prepare chrome driver
        prepareClassProperties(arg0);
        // start target url
        startApplication();
    }
    // Step2: Select userName and click login button
    @When("Select userName and click login button")
    public void SelectUserNameAndClickLoginButton(){
        testDriver=driver;
        loginPage=new P01_HomePage(driver);
        loginPage.loginToXYZBank();
    }
    // Step3: Validate system login successfully
    @Then("Validate system login successfully")
    public void ValidateSystemLoginSuccessfully() {
        // validate if login successfully and in hoe page
        // assert if application start and login correctly
        // take screenshot after successful login
        PageBase.captureScreenshot(driver, "LoginPage");
        // assert if login correctly
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='borderM box padT20 ng-scope'] div:nth-child(1) strong:nth-child(1)")).getText().toString(), "Welcome Albus Dumbledore !!");
        PageBase.assertToObjectExistWithGetText(driver, " Welcome ");
        // extend report status
        test.log(LogStatus.PASS, "Login Correctly to XYZ Bank");
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Albus Dumbledore']")).getText(),"Albus Dumbledore");
        tearDown();
    }
    public WebDriver getTestDriver(){
        return testDriver;
    }

}
