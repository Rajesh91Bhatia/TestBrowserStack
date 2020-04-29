import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class TestNG_WithBS {
	public static final String USERNAME = "rajeshbhatia2";
    public static final String AUTOMATE_KEY = "pAbNdxjwZZkZ5aC9vEKg";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test(enabled=false)
    public void TestGoogleLauchWithBS(String test_browser,String Version, String OS_name, String OS_Version) throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", test_browser);
	    caps.setCapability("browser_version", Version);
	    caps.setCapability("os", OS_name);
	    caps.setCapability("os_version", OS_Version);
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("name", test_browser + "test");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();

  }
	
	@Test
	public void MobileTest() throws MalformedURLException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "11");
		caps.setCapability("device", "iPhone 8 Plus");
		caps.setCapability("real_mobile", "true");
		caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "13.0");
	    caps.setCapability("name", "MobileTest");
	    
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}
	
	@DataProvider(name="BrowserProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Chrome", "81.0","Windows","10"},
            { "IE", "11","Windows","10"},
            { "Firefox", "75","Windows","10"},
            { "Safari", "13.0","OS X","Catalina"}
            
        };
	};
  
  @BeforeMethod
  public void beforeMethod() {
	  
  }

}
