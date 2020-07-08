import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverGet {
	public WebDriver getDriver (String driverName) {
		switch (driverName) {
			case "Chrome" :
				System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
				return new ChromeDriver();
			case "Firefox" :
				System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
				return new FirefoxDriver();
			default :
				return null;
		}
	}
}
