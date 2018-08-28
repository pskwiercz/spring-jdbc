package com.pskwiercz.springjdbc.dao;

import com.pskwiercz.springjdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRawMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {

        return jdbcTemplate.query("select * from person",
                new PersonRawMapper());
    }

    public Person findById(int id) {

        return jdbcTemplate.queryForObject("select * from person where id =?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id =?",
                new Object[]{id});
    }

    public int insert(Person p) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " +
                "values (?, ? ,? ,?)",
                new Object[] {p.getId(), p.getName(), p.getLocation(), p.getBirthDate()});
    }


    public int update(Person p) {
        return jdbcTemplate.update("update person set name = ? , location = ? , birth_date = ? " +
                        "where id = ?",
                new Object[] {p.getName(), p.getLocation(), p.getBirthDate(), p.getId()});
    }

}
