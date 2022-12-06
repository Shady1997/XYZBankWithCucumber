package org.example.Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.example.pages.P02_UserPage;
import org.example.pages.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D02_CheckDepositeOperation extends TestBase{
    P02_UserPage userPage;
    P01_HomePage loginPage;
    @When("Create New Deposit")
    public void createNewDeposit(){
        prepareClassProperties("Chrome");
        startApplication();
        loginPage=new P01_HomePage(driver);
        loginPage.loginToXYZBank();

        userPage = new P02_UserPage(driver);
        userPage.makeDeposite();
    }

    @Then("Deposit Create Successfully")
    public void depositcreatedsuccessfully() {
        // assert Successful Deposit
        PageBase.assertToObjectExistWithGetText(driver, "Deposit Successful");
        // assert new balance after deposit
        Assert.assertEquals(driver.findElement(By.xpath("(//strong[@class='ng-binding'])[2]")).getText().toString(),"1000");
        // take screenshot after successful Deposit
        PageBase.captureScreenshot(driver, "SuccessfulDeposit");
        // extend report status
        test.log(LogStatus.PASS, "Create Deposit Successfully");
        // exit driver
        tearDown();
    }
}
