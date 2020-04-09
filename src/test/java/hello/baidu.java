package hello;

import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class baidu {

	
	    @Before
	    public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://zhidao.baidu.com/");
	        System.out.println("Before"+driver.getTitle());
	    }

	    @Test
	    public void testIn(WebDriver driver) {
	    	driver.get("https://zhidao.baidu.com/");
	    	System.out.println("Test"+driver.getTitle());
	    }
}
