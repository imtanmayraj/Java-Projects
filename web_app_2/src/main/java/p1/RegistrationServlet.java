

package p1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;



@WebServlet("/saveRegister")

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public RegistrationServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String mobile = request.getParameter("mobile");

//	    response.getWriter().println("Name: " + name);
//	    response.getWriter().println("Email: " + email);
//	    response.getWriter().println("Mobile: " + mobile);
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Tanmay1709#");
			
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("insert into student2 values('"+name+"','"+email+"','"+mobile+"')");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


