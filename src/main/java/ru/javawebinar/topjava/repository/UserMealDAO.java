package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
public interface UserMealDAO {
    UserMeal read(int id);
    List<UserMeal> readAll();
    UserMeal update(UserMeal userMeal);
    void delete(int id);
}
