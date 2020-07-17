import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sample {
    public static void main(String[] args) throws InterruptedException {

    	driverGet driverGet = new driverGet();
    	WebDriver driver = driverGet.getDriver("Chrome"); //ChromeかFirefoxを指定
    	System.out.println(driver);

    	MySQLConnector mysql = new MySQLConnector();
    	String[] str = mysql.getResult(1);

    	/*
    	csvReader kadai002 = new csvReader("kadai002.csv"); //CSVの読み込み、読み込みたいファイル名を指定
    	kadai002.check(0); //使うデータの中身の確認、0＝先頭の行
    	String[] str = new String[] { //以下のテスト文で表記しやすいように配列に格納
    			kadai002.getListElement(0, 0),
    			kadai002.getListElement(0, 1),
    			kadai002.getListElement(0, 2),
    			kadai002.getListElement(0, 3)
    	};
    	*/

    	driver.manage().window().maximize();
    	driver.get(str[0]);
    	Thread.sleep(50);
    	WebElement searchBox = driver.findElement(By.name(str[1]));
    	searchBox.sendKeys(str[2]);
    	searchBox.submit();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath(str[3])).click();
    	Thread.sleep(5000);
    	driver.quit();
    }
}