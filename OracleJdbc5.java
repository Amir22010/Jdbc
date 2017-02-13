import java.sql.*;
import java.util.*;
public class OracleJdbc5 {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the gender:");
		String gen=s.next();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			PreparedStatement st=con.prepareStatement("Select * from TMZ where GENDER=? ");
			ResultSet rs=st.executeQuery();
			st.setString(1,gen);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));			
			}
			con.close();
			System.out.println("Selected");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
		
	}
}
