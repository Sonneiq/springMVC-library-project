package ru.saenko.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.saenko.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setPersonId(resultSet.getInt("person_id"));
        book.setName(resultSet.getString("name"));
        book.setYear(resultSet.getInt("year"));
        book.setAuthorName(resultSet.getString("author"));

        return book;
    }
}
