package JAVA_PROJECT;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddClientServlet
 */
@WebServlet("/AddClientServlet")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");

	        Client client = new Client(name, email, phone);

	        try {
	            // Add the client to the database
	            ClientDAO.addClient(client);
	            
	            // If client added successfully, redirect to the homepage
	            response.sendRedirect("home.html");
	        } catch (Exception e) {
	            // If adding client failed, handle the error
	            // You can show an error message or redirect to an error page
	            // For simplicity, let's redirect back to the add client page
	        	System.out.println(e);
	            response.sendRedirect("add_client.jsp");
	        }
	}

}
