package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;

	PageObjects ob;
	@Given("^Navigate to Home page$")
	public void wheniamonhompage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ob=new PageObjects(driver);
	}

	@When("^user enters username and password$")
	public void ienterunameandpwd() {
		ob.SignIn.click();
		ob.username.sendKeys("lalitha");
		ob.password.sendKeys("Password123");
	    ob.Login.click();

	}	

	@Then("^user logged in successfully$")
	public void iamabletologin() {
		System.out.println("User login successfully ");
	}
	
	@When("^Larry searches below products in the search box:$")
	public void larry_searches_below_products(DataTable dt) {
		List<String> product = dt.asList(String.class);
		for(String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
			driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
			driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
			driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		}
	}
		@Then("^product should be added in the cart if available$")
		public void product_should_be_displayed_if_available_in_TestMeApp() {
			System.out.println("Successfully added");
		}
		
		@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
		public void  Loginwithvalidcredentials(String username,String password) {
			ob.SignIn.click();
			ob.username.sendKeys(username);
			ob.password.sendKeys(password);
			ob.Login.click();
			//logout
		}
		
}