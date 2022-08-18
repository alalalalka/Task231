package crud.controller;

import crud.dao.UserDao;
import crud.dao.UserDaoImpl;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String showTable(Model model) {
        model.addAttribute("users", userDao.tableOfUsers());
        return "index";
    }

//    @GetMapping(value = "/{id}")
//    public String getBy(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", userDao.getById(id));
//        return "getBy";
//
//    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userDao.add(user);
        return "redirect:/";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userDao.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id")int id){
        userDao.edit(id, user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        userDao.delete(id);
        return "redirect:/";

    }

}
