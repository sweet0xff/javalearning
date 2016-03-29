import java.sql.*;
import java.sql.Connection;
/**
 * JDBC on SQL server.
 * @author Zeng Ge.
 */

public class SqlserverJdbcTest {

	static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=Meitao";
	static Connection conn = null;
	static Statement sta = null;
	static ResultSet res = null;
	static PreparedStatement pst= null;
	static PreparedStatement psts= null;

public static void main(String[] args) throws ClassNotFoundException,SQLException{
	connectionTest();
	updateTest1();
	updateTest2();
	updateTest3();
	testQuery();
	testQuery2();
	testQuery3();
	conn.close();

	}

	static public void connectionTest()throws ClassNotFoundException,SQLException{
		//注册驱动
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//建立连接
		conn = DriverManager.getConnection(url, "sa", "sa");
		System.out.println("hehe,sql server");
	
	};

	//向数据库插入数据
	static public void updateTest1()throws ClassNotFoundException,SQLException {
		sta = conn.createStatement();
		int ret1 = sta.executeUpdate("insert into Category values('吃大餐',7) ");
		System.out.println(ret1);
		sta.close();
	};
	
	//更新数据库
	static public void updateTest2() throws ClassNotFoundException,SQLException{
		sta = conn.createStatement();
		String name = "美%";
		int ret2 = sta.executeUpdate("update Category set p_categoryID = '200' where categoryName like '"+ name +"' " );
		System.out.println(ret2);
		sta.close();
	}
	
	//删除数据
	static public void updateTest3()throws ClassNotFoundException,SQLException{
		sta = conn.createStatement();
		String name = "洗%";
		int ret3 = sta.executeUpdate("delete from Category where categoryName like '" + name +"' ");

		System.out.println(ret3);
		sta.close();
	};

	//查询
	static public void testQuery() throws ClassNotFoundException,SQLException{
		sta = conn.createStatement();
		res= sta.executeQuery("select * from Category");
		while(res.next()){
			System.out.print(res.getInt(1) + " ");
			System.out.println(res.getString("categoryName"));
		}
		
		res.close();
		sta.close();
	};

	static public void testQuery2() throws ClassNotFoundException,SQLException{
		pst = conn.prepareStatement("select * from Category where categoryName = ?");
		pst.setString(1,"电影");
		res = pst.executeQuery();
		while(res.next()){
			System.out.print(res.getString("categoryName"));
		}
		res.close();
		pst.close();
		conn.close();
		
	};

	static public void testQuery3() throws ClassNotFoundException,SQLException{
		psts = conn.prepareStatement("update Category set categoryName = '呵呵' where categoryName =? ");
		psts.setString(1,"购物");
		psts.execute();
		
		psts.close();
		conn.close();
	};
}
