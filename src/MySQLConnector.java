import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnector {
	static final String URL = "jdbc:mysql://localhost/test_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "**********";

    public String[] getResult(){
    	String[] str = new String[4];
    	try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	        Statement statement = connection.createStatement()) {
    		String sql = "select * from test_db.kadai002";
    		ResultSet result = statement.executeQuery(sql);
    		while ( result.next() ) {
    			for(int i = 1 ; i<5 ; i++) {
                str[i-1] = result.getString(i);
    			}
            }

    		result.close();
    		statement.close();
    		connection.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return str;
    }
}
