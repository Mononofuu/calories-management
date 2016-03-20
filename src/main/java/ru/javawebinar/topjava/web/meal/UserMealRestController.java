package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    @Autowired
    private UserMealService service;

    public void save(UserMeal userMeal) {
        service.save(userMeal);
    }

    public Collection<UserMeal> getAll() {
        return service.getAll(LoggedUser.id());
    }

    public void delete(int id) {
        service.delete(id, LoggedUser.id());
    }

    public UserMeal get(int id) {
        return service.get(id, LoggedUser.id());
    }
}
