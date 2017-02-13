import java.sql.*;
public class OracleJdbc {

	public static void main(String[] args)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from TMZ");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
			con.close();
			System.out.println("Done");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
}
