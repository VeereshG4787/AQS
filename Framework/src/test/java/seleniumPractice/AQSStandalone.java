package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.Framework.RetryAnalyzer;

public class AQSStandalone {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://dewdrops-qcvw.zycus.net/home/auth");
		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("katalon.qc2@zycus.com");
		driver.findElement(By.xpath("//input[@data-toggle='password']")).sendKeys("Autokat@1234");
		driver.findElement(By.xpath("//span[contains(.,'Login')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[.=' What would you like to do today? ']")));
		String ActualText = driver.findElement(By.xpath("//span[.=' What would you like to do today? ']")).getText();
		String ExpectedText = "What would you like to do today?";
		Assert.assertEquals(ActualText, ExpectedText);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (@class,'au--sideMenu ')]")));
		driver.findElement(By.xpath("//span[contains (@class,'au--sideMenu ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Merlin AI Suite']")));
		driver.findElement(By.xpath("//span[.='Merlin AI Suite']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Merlin Store']")));
		driver.findElement(By.xpath("//span[.='Merlin Store']")).click();
	    driver.findElement(By.xpath("//div[@class='row action-buttons-container top-border-light-beige']/span[@class='col action-buttons']"));
		
	}

}