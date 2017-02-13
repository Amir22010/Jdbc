import java.sql.*;
public class OracleJdbc6 {

	public static void main(String[] args)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			
			PreparedStatement stmt=con.prepareStatement("select * from TMZ");
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			System.out.println("Total column: "+rsmd.getColumnCount());
			System.out.println("First column name: "+rsmd.getColumnName(1));
			System.out.println("Second column name: "+rsmd.getColumnName(2));
			System.out.println("Third column name: "+rsmd.getColumnName(3));
			
			con.close();
			System.out.println("Done");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
}
