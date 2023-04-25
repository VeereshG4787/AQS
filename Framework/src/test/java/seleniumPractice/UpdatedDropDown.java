package seleniumPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdatedDropDown {
 public static void main(String[] args) throws InterruptedException {
	 
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 WebDriver driver=new ChromeDriver(options);
	 driver.manage().window().maximize();
	 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	 driver.findElement(By.className("paxinfo")).click();
	 for(int k=1;k<9;k++) {
	 driver.findElement(By.id("hrefIncAdt")).click();
	 Thread.sleep(1000);
	 }
	String noOfAdults= driver.findElement(By.className("paxinfo")).getText();
	System.out.println(noOfAdults);
	 driver.findElement(By.className("buttonN")).click();
	 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	 Thread.sleep(100);
	 driver.findElement(By.xpath("//a[@text='Bengaluru (BLR)']")).click();
	 Thread.sleep(100);
	 driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]")).click();
	 Thread.sleep(100);
	 driver.findElement(By.xpath("(//td//a[@class='ui-state-default'])[4]")).click();
	 driver.findElement(By.xpath("(//input[@name='ctl00$mainContent$btn_FindFlights'])[1]")).click();
	 
	 
	 
}
}
