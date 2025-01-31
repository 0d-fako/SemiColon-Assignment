package mydairy;

import java.time.LocalDate;

public class DairyEntry {
    private int id;
    private String title;
    private String body;
    private LocalDate date;

    public DairyEntry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Date: %s\n Title: %s\n Body: %s\n ",date, title, body);
    }
    
}
