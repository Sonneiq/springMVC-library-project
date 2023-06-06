package ru.saenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.saenko.dao.mapper.BookMapper;
import ru.saenko.dao.mapper.PersonMapper;
import ru.saenko.models.Book;
import ru.saenko.models.Person;

import java.util.List;

@Component
public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    private BookMapper bookMapper;

    private PersonMapper personMapper;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate, BookMapper bookMapper, PersonMapper personMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.bookMapper = bookMapper;
        this.personMapper = personMapper;
    }

    public List<Book> showAll() {
        return jdbcTemplate.query("SELECT * FROM book ORDER BY name", bookMapper);
    }

    public List<Book> showPersonBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new Object[] {id}, bookMapper);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[] {id},
                bookMapper).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(name, author, year) VALUES (?,?,?)",
                book.getName(), book.getAuthorName(), book.getYear());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book SET name=?, author=?, year=? where id=?",
                book.getName(), book.getAuthorName(), book.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book where id=?", id);
    }

    public void setOwner(int id, int personId) {
        jdbcTemplate.update("UPDATE book SET person_id=? where id=?", personId, id);
    }

    public void freeBook(int id) {
        jdbcTemplate.update("UPDATE book SET person_id=null where id=?", id);
    }

    public Person getOwner(int id) {
        return jdbcTemplate.query("SELECT * FROM person JOIN (SELECT * FROM book WHERE id=?) AS b ON person.id = b.person_id",
                new Object[] {id}, personMapper).stream().findAny().orElse(null);
    }
}
