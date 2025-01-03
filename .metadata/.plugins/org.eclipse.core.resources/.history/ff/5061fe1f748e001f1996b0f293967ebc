<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="eventPlanner.eventPlannerDBUtil" %>
<%@ page import="eventPlanner.Event" %>
<%
    int eventId = Integer.parseInt(request.getParameter("eventId"));
    Event event = null;

    // Fetch the event from the database
    try (Connection conn = eventPlannerDBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM event_planner WHERE event_id = ?")) {
        
        stmt.setInt(1, eventId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            event = new Event(
                rs.getInt("event_id"),
                rs.getString("event_type"),
                rs.getString("event_venue"),
                rs.getString("nop"),
                rs.getString("description"),
                rs.getString("event_image_path")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Event</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("images/background1.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .update-event-container {
            background: rgba(255, 255, 255, 0.85);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
            width: 500px;
            text-align: center;
        }

        h2 {
            font-family: 'Poppins', sans-serif;
            font-size: 2.5rem;
            color: #2d3436;
            margin-bottom: 20px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: stretch;
        }

        label {
            font-size: 1rem;
            color: #2d3436;
            text-align: left;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], input[type="number"], textarea {
            padding: 10px;
            border-radius: 10px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
            font-size: 1rem;
            outline: none;
            transition: all 0.3s ease;
        }

        textarea {
            height: 100px;
            resize: none;
        }

        .btn-container {
            display: flex;
            justify-content: space-between;
        }

        .submit-btn {
            background-color: #00b894;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 1rem;
            font-weight: bold;
            transition: all 0.3s ease;
            flex: 1;
            margin-right: 10px;
        }

        .cancel-btn {
            background-color: #d63031;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 1rem;
            font-weight: bold;
            transition: all 0.3s ease;
            flex: 1;
        }
        
        select {
		    padding: 10px;
		    border-radius: 10px;
		    border: 1px solid #ccc;
		    background-color: white;
		    font-size: 1rem;
		    color: #2d3436;
		    appearance: none; /* Remove default styling */
		    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="rgba(0,0,0,0.5)" viewBox="0 0 16 16"><path d="M1 4.5L8 11.5l7-7h-14z"/></svg>'); /* Custom arrow */
		    background-repeat: no-repeat;
		    background-position: right 10px center; /* Position arrow */
		    background-size: 12px; /* Size of arrow */
		    transition: all 0.3s ease;
		}
		
		select:focus {
		    border-color: #00b894; /* Change border color on focus */
		    outline: none; /* Remove default focus outline */
		}
		
		select option {
		    padding: 10px; /* Option padding */
		    background-color: white; /* Option background color */
		    color: #2d3436; /* Option text color */
		}
		
		select:hover {
		    border-color: #00b894; /* Change border color on hover */
		}
        
    </style>
</head>
<body>
    <div class="update-event-container">
        <h2>Update Event</h2>
        <form action="updateEventServlet" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="event_id" value="<%= event.getEventId() %>">

            <label for="event_type">Event Type:</label>
            <select id="event_type" name="event_type" required>
                <option value="<%= event.getEventType() %>" selected><%= event.getEventType() %></option>
                <option value="wedding">Wedding</option>
                <option value="birthday_party">Birthday Party</option>
                <option value="corporate_event">Corporate Event</option>
                <option value="anniversary_celebration">Anniversary Celebration</option>
                <option value="baby_shower">Baby Shower</option>
                <option value="graduation_party">Graduation Party</option>
                <option value="concert">Concert</option>
                <option value="charity_event">Charity Event</option>
                <option value="family_reunion">Family Reunion</option>
                <option value="holiday_party">Holiday Party</option>
                <option value="conference">Conference</option>
                <option value="seminar">Seminar</option>
                <option value="workshop">Workshop</option>
                <option value="prom">Prom</option>
                <option value="sporting_event">Sporting Event</option>
                <option value="picnic">Picnic</option>
                <option value="themed_party">Themed Party</option>
                <option value="farewell_party">Farewell Party</option>
                <option value="art_exhibition">Art Exhibition</option>
                <option value="fashion_show">Fashion Show</option>
            </select>

            <label for="event_venue">Event Venue:</label>
            <input type="text" id="event_venue" name="event_venue" value="<%= event.getEventVenue() %>" required>

            <label for="nop">Number of Participants:</label>
            <input type="number" id="nop" name="nop" value="<%= event.getNop() %>" required>

            <label for="event_description">Event Description:</label>
            <textarea id="event_description" name="event_description" required><%= event.getDescription() %></textarea>

            <label for="event_image">Event Image (optional):</label>
            <input type="file" id="event_image" name="event_image" accept="image/*">

            <div class="btn-container">
                <button type="submit" class="submit-btn">Update</button>
                <a href="EventPage.jsp" class="cancel-btn">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
