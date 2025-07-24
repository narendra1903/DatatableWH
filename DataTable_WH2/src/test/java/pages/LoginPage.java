package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReportingUtil.Reporters;

public class LoginPage {

	WebDriver driver;
	Reporters R1;
	
	@FindBy(name="username")
	WebElement USERNAME;
	
	@FindBy(name="password")
	WebElement PASSWORD;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement LOGINBTN;
	
	
	public void LoginPageDriver(WebDriver driver1,Reporters R2) {
		
		this.driver=driver1;
		this.R1 =R2;
		PageFactory.initElements(driver, this);
	}

	public void user_enters_url_as(String TestURL) {

		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {

		List<Map<String, String>> login = dataTable.asMaps();

		String username = login.get(0).get("Username");

		String password = login.get(0).get("Password");

		USERNAME.sendKeys(username);
		

		PASSWORD.sendKeys(password);

		Thread.sleep(3000);
		
		R1.logger(driver,"Login details" , "successfully entered login credentials");

		LOGINBTN.click();

		Thread.sleep(3000);

	}

}
