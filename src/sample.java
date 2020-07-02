import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

    public static void main(String[] args) throws InterruptedException {

          System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();
          driver.get("http://www.google.com");
          Thread.sleep(50);

          WebElement searchBox = driver.findElement(By.name("q"));
          searchBox.sendKeys("IT media");
          searchBox.submit();

          driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a")).click();;
          Thread.sleep(5000);
          driver.quit();
    }

}