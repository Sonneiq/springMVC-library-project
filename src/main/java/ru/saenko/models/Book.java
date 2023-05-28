package ru.saenko.models;

public class Book {

    private int id;
    private String name;
    private String authorName;
    private int year;

    public Book() {

    }

    public Book(String name, String authorName, int year) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
