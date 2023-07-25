package BrowserTest;

import org.openqa.selenium.WebDriver;g
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.get("https://ganraj.vercel.app/");
        System.out.println(driver.getTitle());
        
        synchronized(driver) {
        	driver.wait(5000);
        }
        driver.close();

	}

}
