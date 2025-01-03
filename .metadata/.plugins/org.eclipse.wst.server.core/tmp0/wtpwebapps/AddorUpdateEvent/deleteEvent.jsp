<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>

<%
    // Get eventId from query string
    int eventId = Integer.parseInt(request.getParameter("eventId"));

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        // Connect to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oeps", "root", "Shehan@24700");

        // SQL query to delete the event
        String sql = "DELETE FROM event_planner WHERE event_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, eventId);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            // Redirect to EventPage.jsp after successful deletion
            response.sendRedirect("EventPage.jsp");
        } else {
            out.println("Failed to delete event.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error: " + e.getMessage());
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
