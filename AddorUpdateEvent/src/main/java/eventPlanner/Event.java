package eventPlanner;

public class Event {
    private int eventId;
    private String eventType;
    private String eventVenue;
    private String nop;
    private String description;
    private String eventImagePath;

    // Constructor
    public Event(int eventId, String eventType, String eventVenue, String nop, String description, String eventImagePath) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventVenue = eventVenue;
        this.nop = nop;
        this.description = description;
        this.eventImagePath = eventImagePath;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public String getNop() {
        return nop;
    }

    public String getDescription() {
        return description;
    }

    public String getEventImagePath() {
        return eventImagePath;
    }
}
