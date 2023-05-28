package ru.saenko.models;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Person {
    @Valid
    private int id;
    @Pattern(regexp = "[А-Я]\\w+ [А-Я]\\w+ [А-Я]\\w+",
        message = "Неверно указано ФИО")
    private String name;
    @Min(value = 1900, message = "Год должен быть не меньше 1900")
    @Max(value = 2023, message = "Год должен быть не больше 2023")
    private int year;
    private List<Book> books;

    public Person() {
        this.books = new ArrayList<>();
    }

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
        this.books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void returnBook(Book book) {
        books.remove(book);
    }
}