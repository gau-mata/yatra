package com.qaclickacademy.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import com.qaclickacademy.reusableComponents.*;
import com.qaclickacademy.uiStore.HomepageUI;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
@RunWith(Cucumber.class)
public class stepDefination {
	WebDriver driver;


    @Given("^User is on \"([^\"]*)\"$")
    public void user_is_on_something(String strArg1) throws Throwable {
		try {
			driver = reusablecomponents.initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.get(strArg1);
    }

    @When("^User click on Login$")
    public void user_click_on_login() throws Throwable {
        reusablemethods.click(HomepageUI.login, driver);
    }

    @Then("^Login page is populated$")
    public void login_page_is_populated() throws Throwable {
    	System.out.println(reusablemethods.gettitle(driver));
    }

    @And("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_username_as_something_and_password_as_something(String strArg1, String strArg2) throws Throwable {
    	
    }

}
