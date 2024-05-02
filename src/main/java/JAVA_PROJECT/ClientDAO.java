package JAVA_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    // Add your database connection manager here
    // Example: private static Connection conn = ConnectionManager.getConnection();
	
    public static void addClient(Client client) throws ClassNotFoundException {
    	Connection con = null;
    	PreparedStatement stmt = null;

    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system","root","root");
    	    String sql = "INSERT INTO clients (name, email, phone) VALUES (?, ?, ?)";
    	    stmt = con.prepareStatement(sql);
    	    stmt.setString(1, client.getName());
    	    stmt.setString(2, client.getEmail());
    	    stmt.setString(3, client.getPhone());
    	    
    	    stmt.executeUpdate();
    	} catch (ClassNotFoundException | SQLException e) {
    	    e.printStackTrace();
    	    // Log the error or handle it as needed
    	} finally {
    	    // Close resources
    	    if (stmt != null) {
    	        try {
    	            stmt.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	    if (con != null) {
    	        try {
    	            con.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }}
    	}

    public static List<Client> getAllClients() throws ClassNotFoundException, SQLException {
        List<Client> clients = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system", "root", "root");
                 PreparedStatement stmt = con.prepareStatement("SELECT * FROM clients");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    
                    Client client = new Client(name, email, phone);
                    client.setId(id); // Set the id for the client
                    clients.add(client);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to handle it at a higher level if needed
        }
        return clients;
    }


    public static Client getClientById(int id) throws ClassNotFoundException {
        // Implement database retrieval by id here
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system","root","root");
            String sql = "SELECT * FROM clients WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                
                client = new Client(name, email, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the error or handle it as needed
        } finally {
            // Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return client;
    }

    public static void updateClient(Client client) throws ClassNotFoundException {
        // Implement database update here
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system","root","root");
            String sql = "UPDATE clients SET name = ?, email = ?, phone = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.setInt(4, client.getId());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the error or handle it as needed
        } finally {
            // Close resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static List<Integer> getAllClientIds() throws ClassNotFoundException {
        List<Integer> allClientIds = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system", "root", "root");
                 PreparedStatement stmt = con.prepareStatement("SELECT id FROM clients");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    allClientIds.add(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return allClientIds;
    }

    
    public static void deleteClient(int id) throws ClassNotFoundException {
        // Implement database deletion here
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client_management_system","root","root");
            String sql = "DELETE FROM clients WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the error or handle it as needed
        } finally {
            // Close resources
            if (stmt != null) {
                try {
                    stmt.close();
                } 
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
