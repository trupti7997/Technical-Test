
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

    public static void main(String[] args) {
        
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32(1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/dp/B01EU2M62S/");
        
        //Get the title of URL
        System.out.println(driver.getTitle());
        
        //Maximize the window
        driver.manage().window().maximize();
        
        //Search without providing any value
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        //perform action just move the mouse
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//click search box,enter capital letter as well select and perform action
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().sendKeys("books").doubleClick().build().perform();
		
		//Select Dropdown Opeartion
		Select s = new Select(driver.findElement(By.id("searchDropdownBox")));
		//s.selectByValue("Books");	
		s.selectByIndex(10);
		
		//Check for Cart
		driver.findElement(By.id("nav-cart-count-container")).click();
		
		//Get the product details
		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("soap");
	    driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
	    
		//close the driver
		 driver.close();
    }
}
