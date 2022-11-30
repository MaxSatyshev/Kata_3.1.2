package com.github.MaxSatyshev.Kata_SpringBoot.dao;

import com.github.MaxSatyshev.Kata_SpringBoot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    private static int USERS_COUNT; //КОЛИЧЕСТВО ЮЗЕРОВ В ТАБЛИЦЕ, ИЗНАЧАЛЬНО 3
    @PersistenceContext
    private EntityManager em;

    public UserDaoImp() {
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        user.setId(++USERS_COUNT);
        em.persist(user);
    }

    @Override
    public void update(int id, User user) {
        User userForUpdate = getUser(id);
        userForUpdate.setName(user.getName());
        userForUpdate.setSurname(user.getSurname());
        userForUpdate.setAge(user.getAge());
        userForUpdate.setPhoneNumber(user.getPhoneNumber());
    }

    @Override
    public void delete(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}
