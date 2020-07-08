import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

public class csvReader {
	List<String> list = null; //list : CSV一行分の情報を入れる
    ArrayList<List<String>> lists = new ArrayList<List<String>>(); //lists : それぞれの行ごとのlistをまとめる

    csvReader (String csvFileName){ //コンストラクタでCSVファイルを読み込ませlists,listに情報をセットする
    	try( ICsvListReader listReader = new CsvListReader( new FileReader("./data/" + csvFileName), CsvPreference.STANDARD_PREFERENCE )) {
    		while( listReader.read() != null ) { //CSVの一行分の情報をlistにいれてそれをlistsにも入れる。最終行まで繰り返す。
          	  this.list = listReader.read();
          	  this.lists.add(list);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getListElement (int listNumber , int elementNumber) {  //第一引数で行数を指定し、第二引数で配列の要素数を指定して取り出す。番号は０始まり
    	return this.lists.get(listNumber).get(elementNumber);
    }

    public void check() { //lists,listの中身を確認するメソッド、引数なしで全情報を出力
    	for( List<String> li : this.lists) {
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
    }

    public void check(int listNumber) {  //lists,listの中身を確認するメソッド、引数ありで0始まりの行の情報のみ出力
    		  List<String> list = this.lists.get(listNumber);
        	  System.out.println("------------------------------------------------------------------------------------");
        	  System.out.println("・listの配列");
        	  System.out.println(list);
        	  System.out.println("");
        	  System.out.println("・listの配列の要素");
        	  for(String str : list) {
        		  System.out.println(str);
        	  }
        	  System.out.println("------------------------------------------------------------------------------------");
    }
}