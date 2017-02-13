import java.sql.*;
import java.util.*;
public class OracleJdbc4 {

	public static void main(String[] args)
	{		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			Statement st=con.createStatement();
			String sql="Select * from TMZ where GENDER='MALE' ";
			ResultSet rs=st.executeQuery(sql);			
			while(rs.next())
			{
				String name=rs.getString("NAME");
				int age=rs.getInt("AGE");
				String gen=rs.getString("GENDER");
				System.out.println("Name :"+name+"\t Age:"+age+"\tGender"+gen);			
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
