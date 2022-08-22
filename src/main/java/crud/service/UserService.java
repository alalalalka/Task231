package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    List<User> showTableOfUsers();
    void addNewUser(User user);
    void delete(int id);
    void edit(int id, User user);
    User getUserById(int id);
}
