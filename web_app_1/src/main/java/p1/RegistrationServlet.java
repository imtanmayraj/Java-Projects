package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/saveReg")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegistrationServlet() {  
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Registration Details</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Mobile: " + mobile + "<br>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET request back to the form (index.html)
        response.sendRedirect("index.html");
    }
}
