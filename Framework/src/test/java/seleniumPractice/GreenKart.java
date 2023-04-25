package seleniumPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] ItemsNeeded = { "Cauliflower", "Tomato", "Walnuts", "Cashews" };
		GreenKart cart = new GreenKart();
		cart.addToCart(driver, ItemsNeeded);
		driver.findElement(By.className("cart-icon")).click();
		List<WebElement> cartDetails=driver.findElements(By.className("cart-item"));
		for(int i=0;i<cartDetails.size();i++) {
			System.out.println(cartDetails.get(i).getText());
		}
		driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(1000);
		System.out.println("=======================Checkout Details=================================");
	List<WebElement>checkoutDetails=driver.findElements(By.xpath("//p[@class='product-name']"));
	for(int j=0;j<checkoutDetails.size();j++) {
		System.out.println(checkoutDetails.get(j).getText());
		System.out.println("-----------------------------------------------");
	}
	    System.out.println("========================================================================");

	driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.className("promoBtn")).click();
	System.out.println(driver.findElement(By.className("promoInfo")).getText());
	driver.findElement(By.xpath("//button[.='Place Order']")).click();
	driver.findElement(By.xpath("//select[@style='width: 200px;']")).click();
    driver.findElement(By.xpath("//select[@style='width: 200px;']")).sendKeys("Ind");
    driver.findElement(By.xpath("//select[@style='width: 200px;']")).sendKeys(Keys.ENTER);
    driver.findElement(By.className("chkAgree")).click();
    driver.findElement(By.xpath("//button[.='Proceed']")).click();
    System.out.println(driver.findElement(By.xpath("//span[@style='color:green;font-size:25px']")).getText());
	driver.close();
	}

	public void addToCart(WebDriver driver, String[] ItemsNeeded) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int k = 0; k < products.size(); k++) {

			String[] product = products.get(k).getText().split("-");
			String formattedName = product[0].trim();
			List neededItemList = Arrays.asList(ItemsNeeded);

			if (neededItemList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(k).click();
				System.out.println(formattedName);
				j++;
				if (j == ItemsNeeded.length) {
					break;
				}
			}

		}
	}
}
