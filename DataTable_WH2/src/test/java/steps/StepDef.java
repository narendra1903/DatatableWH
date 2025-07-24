package steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReportingUtil.Reporters;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SkillsPage;

public class StepDef {
	WebDriver driver;
	Reporters R1;
	
	LoginPage LP;
	SkillsPage SP;
	LogoutPage LP1;

	@Given("user launch the browser")
	public void user_launch_the_browser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Then("user enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		
		LP = new LoginPage();     // classname variablename = new classname();
		LP.LoginPageDriver(driver, R1);
		LP.user_enters_url_as(TestURL);
		
		
		R1 = new Reporters();
		R1.CreateHTMLReport("SkillsRecord");
		

	}

	@Then("user enters login credentials")
	public void user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {

		LP.LoginPageDriver(driver, R1);
		LP.user_enters_login_credentials(dataTable);
		
	}

	@Then("user go to skills page")
	public void user_go_to_skills_page() throws InterruptedException {

		SP = new SkillsPage();
		SP.SkillsPageDriver(driver, R1);
		SP.user_go_to_skills_page();
		
	}

	@When("user enters skill details as")
	public void user_enters_skill_details_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {

		
		SP.SkillsPageDriver(driver, R1);
		SP.user_enters_skill_details_as(dataTable);
	}

	@Then("logout")
	public void logout() {
		
		LP1 = new LogoutPage();
		LP1.LogoutPageDriver(driver, R1);
		LP1.logout();

	}

	@Then("Close browser")
	public void close_browser() {
		
	
		LP1.LogoutPageDriver(driver, R1);
		LP1.close_browser();
        
		R1.closeReport();
	}

}
