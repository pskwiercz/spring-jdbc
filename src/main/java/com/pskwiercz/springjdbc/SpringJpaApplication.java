package com.pskwiercz.springjdbc;

import com.pskwiercz.springjdbc.dao.PersonJdbcDao;
import com.pskwiercz.springjdbc.entity.Person;
import com.pskwiercz.springjdbc.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

    @Autowired
    PersonJpaRepository jpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("JPA find by id: " + jpaRepository.findById(1002));

        Person newPerson = new Person("Kabacki", "Gdansk", new Date());
        jpaRepository.insert(newPerson);

        Person updatedPerson = jpaRepository.findById(1002);
        updatedPerson.setLocation("Lomza");
        jpaRepository.update(updatedPerson);

        jpaRepository.removeById(1002);

        jpaRepository.findAll().stream().forEach(System.out::println);
    }
}
