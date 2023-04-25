package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Gressncart {
 public static void main(String[] args) throws InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver= new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	List<WebElement> product=driver.findElements(By.cssSelector("h4.product-name"));
	
	int P=0;
	for(int i=1;i<product.size();i++) {
	int totalPrice=0;
		String veggieName=product.get(i).getText();
	if(veggieName.contains("")) {
		System.out.println("Cucumber added");
		Thread.sleep(1000);
	driver.findElements(By.className("increment")).get(i).click();
	Thread.sleep(1000);
	driver.findElements(By.xpath("//button[.='ADD TO CART']")).get(i).click();	
	String price=driver.findElements(By.className("product-price")).get(i).getText();
	System.out.println("price"+price);
  P=totalPrice+Integer.parseInt(price);
  System.out.println("Price of Cucumber : "+P);
	continue;
	}
	else if(veggieName.contains("Tomato")){
		System.out.println("Tomato added");
		Thread.sleep(1000);
		driver.findElements(By.className("increment")).get(i).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//button[.='ADD TO CART']")).get(i).click();
		String price=driver.findElements(By.className("product-price")).get(i).getText();
		    P=totalPrice+Integer.parseInt(price);
		    System.out.println("Price of Tomato : "+P);

		continue;
	}
	else if(veggieName.contains("Potato")) {
		System.out.println("Potato added");
		Thread.sleep(1000);
		driver.findElements(By.className("increment")).get(i).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//button[.='ADD TO CART']")).get(i).click();
		String price=driver.findElements(By.className("product-price")).get(i).getText();
		   P=totalPrice+Integer.parseInt(price);
		   System.out.println("Price of Potato : "+P);

		break;
	}

	}
	System.out.println("Total: "+P);
	Thread.sleep(1000);
	driver.findElement(By.className("cart-icon")).click();
}
}
