import java.sql.*;
/**
 * JDBC on MySQL.
 * @author Zeng Ge.
 */

public class MySQLJdbcTest {

	static String url = "jdbc:mysql://127.0.0.1:3306/test";
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, "root", "root");

			System.out.println("OK,mysql");
		}

}
