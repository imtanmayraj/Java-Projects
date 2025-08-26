package com.ems.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.ems.service.DBServiceImpl;


@WebServlet("/updateReg")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateRegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			DBServiceImpl service = new DBServiceImpl();
			service.connectDB();
			ResultSet result = service.getRegistrationById(id);
			int registrationId=0;
			String name=null;
			String course=null;
			String email=null;
			String mobile=null;
			if(result.next()) {
				registrationId = result.getInt(1);
				name = result.getString(2);
				course = result.getString(3);
				email = result.getString(4);
				mobile = result.getString(5);
			}
			
			request.setAttribute("id", registrationId);
			request.setAttribute("name", name);
			request.setAttribute("course", course);
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			String email = (String)session.getAttribute("email");
			
			if(email!=null) {
					
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String course = request.getParameter("course");
			String emailId = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			DBServiceImpl service  = new DBServiceImpl();
			service.connectDB();
			service.updateRegistration(id,name,course,emailId,mobile);
			
			ResultSet result = service.getUserByEmail(email);
			
			int userId = 0;
			if(result.next()) {
				userId = result.getInt(1);
			}
			
			ResultSet registrations = service.getRegistrationsByUser(userId);
			request.setAttribute("registrations", registrations);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
