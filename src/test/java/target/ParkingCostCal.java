package target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import kotlin.WasExperimental;

public class ParkingCostCal {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.shino.de/parkcalc/");
		WebElement element = driver.findElement(By.id("ParkingLot"));
		
		//Choose a Parking Lot by directly list name x path
		//WebElement element1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/select/option[2]"));
		//element1.click();
		
		  //Choose a Parking Lot
		  //Choose a Parking Lot by index
		  Select dropval = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/select")));
	      dropval.selectByIndex(1);
	      Thread.sleep(3000);
		
		

	      String parentHandle = driver.getWindowHandle(); // get the current window handle. This main page is the parent window
	      WebElement dateicon = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/a"));
	      dateicon.click();
	      Thread.sleep(3000);
	      
	      for (String winHandle : driver.getWindowHandles()) {
	    	  
	    	  driver.switchTo().window(winHandle);  // switch focus of WebDriver to the next found window handle (that's your newly opened window (child window))
			
		}
		
		
		WebElement dateselect = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[3]/font"));
		dateselect.click();
		
		
//		driver.close();
//		Thread.sleep(3000);
		
		driver.switchTo().window(parentHandle);
		
		driver.findElement(By.id("StartingTime")).clear(); // Clear the text from the field

		WebElement startTime = driver.findElement(By.id("StartingTime"));
		startTime.sendKeys("09:00");
		
		//................................................
		// Selecting End date
		
		Thread.sleep(3000);
		
		 String parentHandleagain = driver.getWindowHandle(); // get the current window handle. This main page is the parent window
	      WebElement enddateicon = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/a"));
	      enddateicon.click();
	      Thread.sleep(3000);
	      
	      for (String winHandle2 : driver.getWindowHandles()) {
	    	  
	    	  driver.switchTo().window(winHandle2);  // switch focus of WebDriver to the next found window handle (that's your newly opened window (child window End Date))
			
		}
		
	      WebElement enddateselect = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[4]/font"));
		  enddateselect.click();
		  
		  driver.switchTo().window(parentHandle);
			
		  driver.findElement(By.id("LeavingTime")).clear(); // Clear the text from the field

		  WebElement endTime = driver.findElement(By.id("LeavingTime"));
		  endTime.sendKeys("10:30");
		  Thread.sleep(3000);
		  
		  WebElement pmradio = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[4]"));
		  pmradio.click();
		  
		  Thread.sleep(3000);
		  
		  WebElement cal = driver.findElement(By.name("Submit")); // Calculate the parking cost
		  cal.click();
		
	}	  
}
