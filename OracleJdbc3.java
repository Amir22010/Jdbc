import java.sql.*;
import java.util.*;
public class OracleJdbc3 {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name:");
		String name=s.next();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			String sql="Delete from TMZ where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			con.close();
			System.out.println("Record Deleted");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
		s.close();
	}
}
