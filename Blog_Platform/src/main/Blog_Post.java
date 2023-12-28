package main;
import java.sql.*;

public class Blog_Post {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from author");

			while(rs.next())
			{
			System.out.println("author_id: " + rs.getInt(1) + " name: " + rs.getString(2) + " email: "
			+ rs.getString(3) + " password: " + rs.getString(4) );
			}
			con.close();
			} catch(Exception e)
			{
			System.out.println(e);
			}

	}

}

