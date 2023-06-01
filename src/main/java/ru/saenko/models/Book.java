package ru.saenko.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int id;
    private Integer personId;
    @NotEmpty(message = "Обязательно укажите название книги")
    private String name;
    @NotEmpty(message = "Обязательно укажите автора")
    private String authorName;
    @Min(value = 1, message = "Книга не может быть до нашей эры")
    @Max(value = 2023, message = "Книга не может быть моложе текущего года")
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

    public Integer getPersonId() {
        return personId;
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

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
