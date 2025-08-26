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

@WebServlet("/deleteReg")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			
			if(email!=null) {

			DBServiceImpl service = new DBServiceImpl();
			service.connectDB();
			service.deleteRegistration(email);
			
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			String sessionEmail = (String)session.getAttribute("email");
			
			ResultSet result = service.getUserByEmail(sessionEmail);
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}


