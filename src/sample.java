import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

          try( ICsvListReader listReader = new CsvListReader( new FileReader("./data/kadai002.csv"), CsvPreference.STANDARD_PREFERENCE )) {
              List<String> list = null; //list : CSV一行分の情報を入れる
              ArrayList<List<String>> lists = new ArrayList<List<String>>();//lists : それぞれの行ごとのlistをまとめる

              while( listReader.read() != null ) { //CSVの一行分の情報をlistにいれてそれをlistsにも入れる。最終行まで繰り返す。
            	  list = listReader.read();
            	  lists.add(list);
              }

              //listsとlistの内容を確認
              for( List<String> li : lists) {
            	  System.out.println("------------------------------------------------------------------------------------");
            	  System.out.println("・listの配列");
            	  System.out.println(li);
            	  System.out.println("");
            	  System.out.println("・listの配列の要素");
            	  for(String str : li) {
            		  System.out.println(str);
            	  }
            	  System.out.println("------------------------------------------------------------------------------------");
              }

              //listsの一番目からテストを実行
              for( int i = 0 ; i < lists.size() ; i++) {
            	  List<String> nthList = lists.get(i);

            	  driver.manage().window().maximize();
                  driver.get(nthList.get(0));
                  Thread.sleep(50);
                  WebElement searchBox = driver.findElement(By.name(nthList.get(1)));
                  searchBox.sendKeys(nthList.get(2));
                  searchBox.submit();
                  driver.findElement(By.xpath(nthList.get(3))).click();
                  Thread.sleep(5000);
                  driver.quit();
              }

          } catch (IOException e) {
              throw new RuntimeException(e);
          }

    }

}