package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal save(UserMeal userMeal) {
        return repository.save(userMeal);
    }

    @Override
    public void delete(int id, int userId) {
        UserMeal userMeal = repository.get(id);
        if (userMeal.getUserId() == userId) {
            repository.delete(id);
        } else {
            throw new NotFoundException("Entry not founded!");
        }
    }

    @Override
    public UserMeal get(int id, int userId) {
        UserMeal userMeal = repository.get(id);
        if (userMeal.getUserId() == userId) {
            return userMeal;
        } else {
            throw new NotFoundException("Entry not founded!");
        }
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return repository.getAll().stream().filter(userMeal -> userMeal.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public void update(UserMeal userMeal, int userId) {
        if (userMeal.getUserId() == userId) {
            repository.save(userMeal);
        }
    }
}
