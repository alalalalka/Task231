package crud.service;

import crud.dao.UserDao;
import crud.dao.UserDaoImpl;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> tableOfUsers() {
        return userDao.tableOfUsers();
    }

    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Override
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    public void edit(int id, User user) {
        userDao.edit(id,user);
    }


    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
