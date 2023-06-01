package ru.saenko.models;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    @Pattern(regexp = "[А-Я]{1}[а-я]{1,} [А-Я]{1}[а-я]{1,} [А-Я]{1}[а-я]{1,}",
        message = "Укажите ФИО согласно примеру: Иванов Иван Иванович")
    @NotEmpty(message = "Данное поле не должно быть пустым")
    private String name;
    @Min(value = 1900, message = "Год должен быть не меньше 1900")
    @Max(value = 2023, message = "Год должен быть не больше 2023")
    private int year;

    public Person() {
    }

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
