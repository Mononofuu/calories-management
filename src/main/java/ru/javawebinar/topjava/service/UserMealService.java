package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {

    UserMeal save(UserMeal userMeal);

    void delete(int id, int userId);

    UserMeal get(int id, int userId);

    List<UserMeal> getAll(int userId);

    void update(UserMeal userMeal, int userId);
}
