import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		SQLTester j=new SQLTester();
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=foo&password=bar");
			j.insertBook(connect);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void insertBook(Connection connect)
	{
		try {
			PreparedStatement s = connect.prepareStatement("insert into  feedback.books4 values (default,?, ?, ?)");
			s.setString(1, "Tapeter och solsken");
			s.setString(2, "Janne Andersson");
			s.setInt(3, 876);
			s.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
