import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;


public class sample {

    public static void main(String[] args) throws InterruptedException {

          System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();
          driver.get("http://www.google.com");
          Thread.sleep(50);





          try(ICsvListReader listReader = new CsvListReader(new FileReader("./data/kadi002.csv"), CsvPreference.STANDARD_PREFERENCE)) {
              List<String> list = null;
              for(Iterator it = list.iterator(); it.hasNext();) {
                  System.out.println(it.next());
              }
              while ((list = listReader.read()) != null) ;
          } catch (IOException e) {
              throw new RuntimeException(e);
          }




          WebElement searchBox = driver.findElement(By.name("q"));
          searchBox.sendKeys("IT media");
          searchBox.submit();

          driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a")).click();
          Thread.sleep(5000);
          driver.quit();
    }

}