package com.web_app_5.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.web_app_5.model.AddService;


@WebServlet("/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		AddService service = new AddService();
		int result = service.addNumbers(num1, num2);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
 
		rd.forward(request, response);
	}

}
