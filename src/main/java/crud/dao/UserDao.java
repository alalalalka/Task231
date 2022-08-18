package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {

    List<User> tableOfUsers();
    void add(User user);
    void delete(int id);

    void edit(int id, User user);

    User getById(int id);

}
