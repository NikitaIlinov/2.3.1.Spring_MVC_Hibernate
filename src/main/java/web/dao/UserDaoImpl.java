package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        if(user.getId() != null) {
            User updateUser = entityManager.find(User.class, user.getId());
            updateUser.setName(user.getName());
            updateUser.setAge(user.getAge());
            entityManager.persist(updateUser);
        } else {
            entityManager.persist(user);
        }
        entityManager.close();
    }

    @Override
    public void deleteUser(Long id)  {
        entityManager.remove(findById(id));
    }


    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
