package com.pskwiercz.springjdbc.jpa;

import com.pskwiercz.springjdbc.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager em;

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public Person insert(Person p) {
        return em.merge(p);
    }

    public Person update(Person p) {
        return em.merge(p);
    }

    public void removeById(int id) {
        Person byId = findById(id);
        em.remove(byId);
    }

    public List<Person> findAll() {
        TypedQuery<Person> find_all_persons = em.createNamedQuery("find_all_persons", Person.class);
        return find_all_persons.getResultList();
    }
}
