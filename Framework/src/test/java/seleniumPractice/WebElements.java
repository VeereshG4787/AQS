package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://dewdrops-rp.zycus.com/home/auth");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("auto.usprod1@zycus.com");
		driver.findElement(By.xpath("//input[@data-toggle='password']")).sendKeys("c?7B$l7i7?#I");
		driver.findElement(By.xpath("(//span[@class='btn-text d-block'])[3]")).click();
		
		
	}
}
