package dao;
import java.sql.*;
public class AdminDAO 
{
	Connection con=null;
	Statement stmt=null;
	PreparedStatement ps=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	public AdminDAO()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","instagram");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//Logic For Data Display
	public ResultSet adminValidate(String userId, String password,String role)
	{
		try
		{
			String sql="select * from login where  login_id=? AND password=? AND status=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,password);
			ps.setString(3,role);
			rs=ps.executeQuery();
			return rs;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
