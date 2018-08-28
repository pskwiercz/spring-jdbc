package com.pskwiercz.springjdbc;

import com.pskwiercz.springjdbc.dao.PersonJdbcDao;
import com.pskwiercz.springjdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDao personDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        personDao.findAll().stream().forEach(System.out::println);

        System.out.println("Find person: " + personDao.findById(1002));

        System.out.println("Delete person: " + personDao.deleteById(1001));
        personDao.findAll().stream().forEach(System.out::println);

        Person person = new Person(10001, "Adam", "Warszawa", new Date());
        personDao.insert(person);
        personDao.findAll().stream().forEach(System.out::println);

        person.setName("Barbara");
        personDao.update(person);
        personDao.findAll().stream().forEach(System.out::println);
    }
}
