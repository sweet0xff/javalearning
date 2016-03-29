import java.sql.Connection;
/**
 * JDBC on Oracle.
 * @author Zeng Ge.
 */

public class OracleJdbcTest {

	static String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, "scott", "tiger");
		System.out.println("OK ,oracle ");
	}
}