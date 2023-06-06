package ru.saenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.saenko.dao.mapper.BookMapper;
import ru.saenko.dao.mapper.PersonMapper;
import ru.saenko.models.Book;
import ru.saenko.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    private final PersonMapper personMapper;

    private final BookMapper bookMapper;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate, PersonMapper personMapper, BookMapper bookMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.personMapper = personMapper;
        this.bookMapper = bookMapper;
    }

    public List<Person> showAll() {
        return jdbcTemplate.query("SELECT * FROM person ORDER BY name", personMapper);
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[] {id},
                personMapper).stream().findAny().orElse(null);
    }

    public List<Book> showPersonBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new Object[] {id}, bookMapper);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, year) VALUES (?,?)", person.getName(), person.getYear());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE person SET name=?, year=? WHERE id=?", person.getName(), person.getYear(), id);
    }

    public Optional<Person> getByName(String name) {
        return jdbcTemplate.query("SELECT * FROM person WHERE name=?", new Object[] {name},
                personMapper).stream().findAny();
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT * FROM person JOIN (SELECT * FROM book WHERE id=?) AS b ON person.id = b.person_id",
                new Object[] {id}, personMapper).stream().findAny();
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
