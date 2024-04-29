package utility;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	static Connection con=null;
	public static Connection getConnection() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
			System.out.println("connection established");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;

	}

}
