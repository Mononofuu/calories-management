package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public Collection<UserMealWithExceed> getAll() {
        return UserMealsUtil.getWithExceeded(service.getAll(LoggedUser.getId()), UserMealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public Collection<UserMealWithExceed> getAll(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return UserMealsUtil.getFilteredWithExceededByDates(service.getAll(LoggedUser.getId()), startDate, startTime, endDate, endTime, UserMealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public void delete(int id) {
        service.delete(id, LoggedUser.getId());
    }

    public UserMeal get(int id) {
        return service.get(id, LoggedUser.getId());
    }
}
