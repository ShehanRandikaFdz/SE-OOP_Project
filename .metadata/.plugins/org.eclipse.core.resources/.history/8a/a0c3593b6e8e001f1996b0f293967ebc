<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="eventPlanner.Event" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("images/background1.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        #event-header {
            background: linear-gradient(135deg, #FF4F81, #A500B5);
            color: white;
            text-align: center;
            padding: 20px;
            border-radius: 0 0 20px 20px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
        }

        #event-header h1 {
            font-family: 'Poppins', sans-serif;
            font-size: 3rem;
            margin: 0;
            text-transform: uppercase;
        }

        #event-header p {
            font-family: 'Roboto', sans-serif;
            font-size: 1.2rem;
            margin-top: 10px;
            font-style: italic;
        }

        #add-event-btn {
            position: fixed;
            top: 20px;
            right: 20px;
            background: linear-gradient(135deg, #FFD700, #FF8C00);
            color: black;
            border: none;
            padding: 12px 25px;
            cursor: pointer;
            border-radius: 30px;
            font-size: 18px;
            font-family: Nunito;
            font-weight: bold;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
        }

        #add-event-btn:hover {
            background: linear-gradient(135deg, #00BFFF, #00FF7F);
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
        }

        #event-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin: 40px 20px;
        }

        .event-card {
            background-color: white;
            margin: 20px;
            border-radius: 15px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            width: 320px;
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }

        .event-card:hover {
            transform: scale(1.05);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }

        .event-image {
            width: 100%;
            height: 200px;
            background-size: cover;
            background-position: center;
        }

        .event-details {
            padding: 20px;
            color: #2d3436;
        }

        .event-details h3 {
            margin: 0;
            font-size: 1.6rem;
            color: #2d3436;
            font-weight: 600;
        }

        .event-details p {
            font-size: 0.95rem;
            margin: 10px 0;
            color: #636e72;
        }

        .event-details .event-type {
            display: inline-block;
            padding: 5px 10px;
            background-color: #e84393;
            color: white;
            font-size: 0.85rem;
            border-radius: 8px;
            margin-bottom: 15px;
        }

        .event-details .event-description {
            font-size: 0.9rem;
            color: #636e72;
        }

        .event-details .more-info {
            color: #0984e3;
            text-decoration: none;
            font-weight: 600;
            display: inline-block;
            margin-top: 10px;
        }

        .event-details .more-info:hover {
            text-decoration: underline;
        }

        /* Update and Delete Buttons */
        .event-details .action-btn {
            display: inline-block;
            margin: 10px 5px 0 0;
            padding: 8px 15px;
            border-radius: 20px;
            text-decoration: none;
            font-size: 0.9rem;
            font-weight: bold;
            transition: background 0.3s ease, transform 0.3s ease;
        }

        .event-details .update-btn {
            background-color: #00b894;
            color: white;
        }

        .event-details .update-btn:hover {
            background-color: #00cec9;
            transform: translateY(-3px);
        }

        .event-details .delete-btn {
            background-color: #d63031;
            color: white;
        }

        .event-details .delete-btn:hover {
            background-color: #ff7675;
            transform: translateY(-3px);
        }

        /* Modal Styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            overflow: auto;
        }

        .modal-content {
            background-color: white;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 60%;
            border-radius: 10px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.3);
        }

        .modal-header h3 {
            margin: 0;
            font-size: 2rem;
            color: #2d3436;
        }

        .modal-body p {
            margin: 10px 0;
            font-size: 1.1rem;
            color: #636e72;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div id="event-header">
        <h1>Events</h1>
        <p>Explore Our Exciting Upcoming Events!</p>
    </div>

    <button id="add-event-btn" onclick="window.location.href='addEvent.jsp'">Add Event</button>

    <div id="event-list">
        <%
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet resultSet = null;
            List<Event> eventList = new ArrayList<>();

            try {
                // Establish database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oeps", "root", "Shehan@24700");

                // SQL query to retrieve events
                String sql = "SELECT * FROM event_planner";
                stmt = conn.prepareStatement(sql);
                resultSet = stmt.executeQuery();

                // Loop through the results and add to the eventList
                while (resultSet.next()) {
                    int eventId = resultSet.getInt("event_id");
                    String eventType = resultSet.getString("event_type");
                    String eventVenue = resultSet.getString("event_venue");
                    String nop = resultSet.getString("nop");
                    String description = resultSet.getString("description");
                    String eventImagePath = resultSet.getString("event_image_path");

                    // Create an Event object and add it to the list
                    Event event = new Event(eventId, eventType, eventVenue, nop, description, eventImagePath);
                    eventList.add(event);
                }

                // Display events if available
                if (!eventList.isEmpty()) {
                    for (Event event : eventList) {
        %>
                        <div class="event-card">
						    <div class="event-image" style="background-image: url('uploads/<%= event.getEventImagePath() %>');"></div>
						    <div class="event-details">
						        <h3><%= event.getEventType() %></h3>
						        <span class="event-type"><%= event.getEventType() %></span>
						        <p>Venue: <%= event.getEventVenue() %></p>
						        <p>Participants: <%= event.getNop() %></p>
						        <p class="event-description"><%= event.getDescription().length() > 100 ? event.getDescription().substring(0, 100) + "..." : event.getDescription() %></p>
						        
						        <!-- More Info Button -->
						        <a href="javascript:void(0);" class="more-info" onclick="openModal('<%= event.getEventType() %>', '<%= event.getEventVenue() %>', '<%= event.getNop() %>', '<%= event.getDescription() %>', 'uploads/<%= event.getEventImagePath() %>')">More Info</a>
						        
						        <!-- Update Button -->
						        <a href="updateEvent.jsp?eventId=<%= event.getEventId() %>" class="action-btn update-btn">Update</a>
						        
						        <!-- Delete Button -->
						        <a href="deleteEvent.jsp?eventId=<%= event.getEventId() %>" class="action-btn delete-btn" onclick="return confirm('Are you sure you want to delete this event?');">Delete</a>
						    </div>
						</div>

        <%
                    }
                } else {
                    out.println("<p>No events found.</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p>Error retrieving events.</p>");
            } finally {
                // Close database resources
                try {
                    if (resultSet != null) resultSet.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        %>
    </div>

    <!-- Modal -->
    <div id="eventModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <div class="modal-header">
                <h3 id="modalEventType"></h3>
            </div>
            <div class="modal-body">
                <p><strong>Venue:</strong> <span id="modalEventVenue"></span></p>
                <p><strong>Participants:</strong> <span id="modalEventNop"></span></p>
                <p><strong>Description:</strong> <span id="modalEventDescription"></span></p>
                <img id="modalEventImage" style="width: 100%; border-radius: 10px;" />
            </div>
        </div>
    </div>

    <script>
        // Function to open the modal and populate event details
        function openModal(eventType, eventVenue, nop, description, imagePath) {
            document.getElementById('modalEventType').textContent = eventType;
            document.getElementById('modalEventVenue').textContent = eventVenue;
            document.getElementById('modalEventNop').textContent = nop;
            document.getElementById('modalEventDescription').textContent = description;
            document.getElementById('modalEventImage').src = imagePath;
            document.getElementById('eventModal').style.display = "block";
        }

        // Function to close the modal
        function closeModal() {
            document.getElementById('eventModal').style.display = "none";
        }

        // Close the modal when clicking outside of it
        window.onclick = function(event) {
            if (event.target == document.getElementById('eventModal')) {
                closeModal();
            }
        }
    </script>
</body>
</html>
