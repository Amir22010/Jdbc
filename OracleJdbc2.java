import java.sql.*;
import java.util.*;
public class OracleJdbc2 {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name:");
		String name=s.next();
		System.out.println("Enter the age:");
		int age=s.nextInt();
		System.out.println("Enter the gender:");
		String gen=s.next();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","apple","io");
			String sql="Insert into TMZ values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gen);
			ps.executeUpdate();
			con.close();
			System.out.println("Record Inserted");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
		s.close();
	}
}
