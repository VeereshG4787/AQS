package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {
 public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	WebElement staticDropDown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select dropdown=new Select(staticDropDown);
	dropdown.selectByIndex(3);
	System.out.println(dropdown.getFirstSelectedOption().getText());
	dropdown.selectByVisibleText("AED");
	System.out.println(dropdown.getFirstSelectedOption().getText());
//	driver.close();
}
}
