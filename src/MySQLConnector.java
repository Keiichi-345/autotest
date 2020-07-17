import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnector {
	static final String URL = "jdbc:mysql://localhost/test_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "****************";
    private ArrayList<String[]> resultArray = new ArrayList<String[]>();//コンストラクタによりSQLの行ごとの情報を配列としてArrayListに格納

    MySQLConnector() {
    	try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	        Statement statement = connection.createStatement()) {
    		String sql = "select * from test_db.kadai002";
    		ResultSet result = statement.executeQuery(sql);

    		String[] array = new String[4];
    		int i = 0;
    		while ( result.next() ) {
    			for(int j = 0 ; j<4 ; j++) {
    				array[j] = result.getString(j+1);
    			}
    			resultArray.add(i,array);
    			System.out.println("----------------------------------------------------------------------------------");
    			System.out.println(resultArray.get(i)[0]);
    			System.out.println(resultArray.get(i)[1]);
    			System.out.println(resultArray.get(i)[2]);
    			System.out.println(resultArray.get(i)[3]);
    			i++;
            }

    		result.close();
    		statement.close();
    		connection.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public  String[] getResult( int rowNumber ){
    	return this.resultArray.get(rowNumber - 1);
    }

    public void check() {
    	for (int i = 0;i<3;i++) {
    		System.out.println("----------------------------------------------------------------------------------");
    		for (int j = 0 ; j<4 ; j++) {
    		System.out.println(this.resultArray.get(i)[j]);
    		}

    	}

    }
}
