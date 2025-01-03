package eventPlanner;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Specify where to store uploaded files
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB

@WebServlet("/addEventServlet")
public class addEventServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventType = request.getParameter("event_type");
        String eventVenue = request.getParameter("event_venue");
        String nop = request.getParameter("nop");
        String eventDescription = request.getParameter("event_description");
        
        // Part object for the image
        Part eventImage = request.getPart("event_image");
        
        String imagePath = null;
        if (eventImage != null && eventImage.getSize() > 0) {
            String fileName = extractFileName(eventImage);
            
            // Get the absolute path to the "uploads" directory within the web application
            String uploadDir = getServletContext().getRealPath("/uploads"); 
            File uploadDirFile = new File(uploadDir);
            
            // Ensure the directory exists
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs(); // Create the uploads directory if it doesn't exist
            }
            
            // Save the image file to the uploads directory
            String savePath = uploadDir + File.separator + fileName; 
            eventImage.write(savePath);
            
            // Save only the file name in the database, not the full path
            imagePath = fileName;  
        }


        try {
            saveEventToDatabase(eventType, eventVenue, nop, eventDescription, imagePath);
        } catch (SQLException e) {
            e.printStackTrace();  // This will print more detailed SQL error info in the logs
            response.getWriter().println("Error saving event to the database: " + e.getMessage());
            return;
        }


        // Redirect back to event page after successful submission
        response.sendRedirect("EventPage.jsp");
    }

    // Utility method to extract the file name from the Part object
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    // Method to save event details to the database
    private void saveEventToDatabase(String eventType, String eventVenue, String nop, String eventDescription, String imagePath)
            throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Get the connection from DB Utility
            conn = eventPlannerDBUtil.getConnection();

            if (conn == null) {
                throw new SQLException("Failed to establish a database connection.");
            }

            // SQL query to insert event data into the database (excluding the auto-increment column `event_id`)
            String sql = "INSERT INTO event_planner (event_type, event_venue, nop, description, event_image_path) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventType);
            stmt.setString(2, eventVenue);
            stmt.setString(3, nop);
            stmt.setString(4, eventDescription);
            stmt.setString(5, imagePath); 


            // Execute the insert statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
