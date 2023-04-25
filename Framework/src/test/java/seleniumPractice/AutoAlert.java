package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AutoAlert {

	public static void main(String[] args) throws InterruptedException {
		 ChromeOptions op=new ChromeOptions();
		 op.addArguments("--remote-allow-origins=*");
		 WebDriver driver=new ChromeDriver(op);
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 Thread.sleep(1000);
		 driver.findElement(By.id("divpaxinfo")).click();
		 for(int i=1;i<10;i++) {
			 Thread.sleep(1000);
		 driver.findElement(By.id("hrefIncAdt")).click();
		 Thread.sleep(1000);
		 }
		String Actual_alert= driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
		 String alert="You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center.";
		 Assert.assertEquals(Actual_alert, alert);
		 driver.quit();
	}

}
