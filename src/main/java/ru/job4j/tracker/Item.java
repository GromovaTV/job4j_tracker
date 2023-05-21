package ru.job4j.tracker;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public Item(int id, String name, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.created = timestamp.toLocalDateTime();
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(Timestamp timestamp) {
        this.created = timestamp.toLocalDateTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}