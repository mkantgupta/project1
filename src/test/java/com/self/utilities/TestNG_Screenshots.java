package com.self.utilities;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Screenshots {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		baseUrl = "https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
		driver = new ChromeDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test1_invalidCredentials() throws Exception {
		driver.findElement(By.partialLinkText("Hello, Sign in")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("g48@gmail.com");
		driver.findElement(By.className("a-button-input")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Amazo123@");
		driver.findElement(By.id("signInSubmit")).click();
		
		Thread.sleep(3000);
		
		WebElement welcomeText = null;
		
		try {
			welcomeText = driver.findElement(By.xpath("/html//span[@id='nav-link-accountList-nav-line-1']"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Screenshots.takeScreenshot(driver, testResult.getName());
		}
		driver.quit();
	}
}