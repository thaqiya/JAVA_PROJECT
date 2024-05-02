package JAVA_PROJECT;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gettingid
 */
@WebServlet("/gettingid")
public class gettingid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gettingid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<Integer> allClientIds = null;
	        try {
	            allClientIds = ClientDAO.getAllClientIds();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            // Handle the exception
	        }

	        // Set the list of IDs as a request attribute
	        request.setAttribute("allClientIds", allClientIds);

	        // Forward the request to the JSP
	        request.getRequestDispatcher("edit_client.jsp").forward(request, response);
	    }
	}


