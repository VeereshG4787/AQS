package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locaters {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("inputUsername")).sendKeys("veereshanand13@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("?><Mnbvcxz@123");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		String msg=driver.findElement(By.xpath("//p[@class='error']")).getText();
		System.out.println(msg);
		driver.close();
		
		
		

	}

}
