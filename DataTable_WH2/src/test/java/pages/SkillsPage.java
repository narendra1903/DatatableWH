package pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReportingUtil.Reporters;

public class SkillsPage {
	WebDriver driver;
	Reporters R1;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	WebElement ADMIN;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span")
	WebElement QUALIFICATIONS;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]")
	WebElement SKILLS;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
	WebElement ADDBTN;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement SKILLNAME;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
	WebElement SKILLDESCR;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
	WebElement SAVEBTN;

	public void SkillsPageDriver(WebDriver driver1,Reporters R2) {

		this.driver = driver1;
		this.R1=R2;
		PageFactory.initElements(driver, this);
	}

	public void user_go_to_skills_page() throws InterruptedException {

		ADMIN.click();
		Thread.sleep(3000);

		QUALIFICATIONS.click();
		Thread.sleep(3000);

		SKILLS.click();
		Thread.sleep(3000);
	
	}

	public void user_enters_skill_details_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {

		List<Map<String, String>> skilldetails = dataTable.asMaps();

		for (int i = 0; i < skilldetails.size(); i++) {

			String skillname = skilldetails.get(i).get("SkillName"); // 3,skilllname

			String skilldesc = skilldetails.get(i).get("SkillDescription"); // 3,skilldescription

			ADDBTN.click();
			Thread.sleep(3000);
			R1.logger(driver, "Skillspage", "without entering skill details");

			SKILLNAME.sendKeys(skillname);

			SKILLDESCR.sendKeys(skilldesc);
			Thread.sleep(3000);

			R1.logger(driver, "skillsdetails", "after entering skill details");
			SAVEBTN.click();
		}
	}

}
