package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

//    private static final AtomicInteger AUTO_ID = new AtomicInteger();
//    private List<User> users;
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(AUTO_ID.getAndIncrement(),"Oleg",20));
//        users.add(new User(AUTO_ID.getAndIncrement(),"Maksim",45));
//        users.add(new User(AUTO_ID.getAndIncrement(),"Anna",34));
//
//    }

    @Override
    public List<User> tableOfUsers() {
        String jpql = "SELECT c FROM User c";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        return query.getResultList();
    }

    @Override
    public void add(User user) {
//        user.setId(AUTO_ID.getAndIncrement());
//        users.add(user);
        entityManager.persist(user);

    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
//        users.removeIf(user -> user.getId() == id);

    }

    @Override
    public void edit(int id, User updatedUser) {

        entityManager.merge(updatedUser);
//        User userToBeUpdated = getById(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setAge(updatedUser.getAge());

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
