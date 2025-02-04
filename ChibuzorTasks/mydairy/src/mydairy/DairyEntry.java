package mydairy;

import java.time.LocalDate;

public class DairyEntry {
    private int id;
    private String title;
    private String body;
    private LocalDate date;

    public DairyEntry(int id, String title, String body) {
        this.id = id;
        setTitle(title);
        setBody(body);
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        if(body == null || body.isEmpty()) throw new IllegalArgumentException("Body cannot be null or empty");
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("Date: %s\n Title: %s\n Body: %s\n ",date, title, body);
    }

}
