package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		//pw.println("Hello"); 
		String userId=request.getParameter("Username");
		String password=request.getParameter("Password");
		String loginAs=request.getParameter("loginAs");
		RequestDispatcher rd=null;
		ResultSet rs=null;
		switch(loginAs)
		{
		case "Admin":
		{
			AdminDAO dao=new AdminDAO();
			try
			{
			rs=dao.adminValidate(userId, password, loginAs);
			if(rs.next())
			{
				rd=request.getRequestDispatcher("adminPanel.jsp");
				request.setAttribute("Uname",rs.getString(1));
				rd.forward(request,response);
			}
			else
			{
				String error="Invalid credentials!";
				rd=request.getRequestDispatcher("invalidLogin.jsp");
				request.setAttribute("error",error);
				rd.forward(request,response);
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		}
		
		case "HR":
		{
			AdminDAO dao=new AdminDAO();
			try
			{
			rs=dao.adminValidate(userId, password, loginAs);
			if(rs.next())
			{
				rd=request.getRequestDispatcher("hrPanel.jsp");
				request.setAttribute("Uname",rs.getString(1));
				rd.forward(request,response);
			}
			else
			{
				String error="Invalid credentials!";
				rd=request.getRequestDispatcher("invalidLogin.jsp");
				request.setAttribute("error",error);
				rd.forward(request,response);
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		}
		case "Employee":
		{
			AdminDAO dao=new AdminDAO();
			try
			{
			rs=dao.adminValidate(userId, password, loginAs);
			if(rs.next())
			{
				rd=request.getRequestDispatcher("employeePanel.jsp");
				request.setAttribute("Uname",rs.getString(1));
				rd.forward(request,response);
			}
			else
			{
				String error="Invalid credentials!";
				rd=request.getRequestDispatcher("invalidLogin.jsp");
				request.setAttribute("error",error);
				rd.forward(request,response);
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		}
		default:
		{
			response.sendRedirect("login.jsp");
		}
		}
	}

}
