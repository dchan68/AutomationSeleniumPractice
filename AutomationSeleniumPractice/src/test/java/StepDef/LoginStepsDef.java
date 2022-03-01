package StepDef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utility.DriverUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDef {
	
	private DriverUtilities du = DriverUtilities.getInstance();
	private WebDriver driver = du.getDriver();
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		
		WebElement homePageLabel = driver.findElement(By.className("brand"));
		Thread.sleep(2000);
		String actualHomePageLabelText = homePageLabel.getText();
		assertEquals("Zero Bank", actualHomePageLabelText);		
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.className("signin")).click();
		WebElement signInPageLabel = driver.findElement(By.className("page-header"));
		String actualSignInPageLabelText = signInPageLabel.getText();
		assertEquals("Log in to ZeroBank", actualSignInPageLabelText);
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
	}

	@And("clicks sign in")
	public void clicks_sign_in() {
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
	}

	@Then("user is nagivated to home page")
	public void user_is_nagivated_to_home_page() {
		driver.navigate().back();
		WebElement usernameText = driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]"));
		String actualUsernameText = usernameText.getText();
		assertEquals("username", actualUsernameText);
		driver.quit();
	}
}
