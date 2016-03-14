package ru.javawebinar.topjava.repository;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
public class MapUserMealDAOImpl implements UserMealDAO {
    private static final Logger LOG = getLogger(MapUserMealDAOImpl.class);
    private int id;
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();

    {

        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public int getId() {
        return id;
    }

    private UserMeal create(UserMeal userMeal) {
        userMeal.setId(++id);
        repository.put(userMeal.getId(), userMeal);
        LOG.debug("New UserMeal created with id=" + getId());
        return userMeal;
    }

    @Override
    public UserMeal read(int id) {
        return repository.get(id);
    }

    @Override
    public List<UserMeal> readAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public UserMeal update(UserMeal userMeal) {
        if (userMeal.getId()==0){
            userMeal =  create(userMeal);
        }else {
            repository.put(userMeal.getId(), userMeal);
        }
        return userMeal;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
        LOG.debug("UserMeal deleted with id=" + id);

    }
}
