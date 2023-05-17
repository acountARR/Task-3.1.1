package ru.arromaev.task311.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.arromaev.task311.model.User;

import java.util.List;


@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }


    @Override
    public void addUser(User user) {
        getEntityManager().persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("FROM User").getResultList();
    }

    @Override
    public void editUser(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public void deleteUser(int id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserById(int id) {
        return getEntityManager().find(User.class, id);
    }
}
