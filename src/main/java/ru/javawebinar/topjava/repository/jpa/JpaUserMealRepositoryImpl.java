package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
//        User user = em.find(User.class, userId); // get full object
        User user = em.getReference(User.class, userId); // we get only proxy with primary key initialized
        if (userMeal.isNew()) {
            userMeal.setUser(user);
            em.persist(userMeal);
        } else {
            if (userMeal.getUser() != null && userMeal.getUser().getId() != userId) {
                return null;
            }
            userMeal.setUser(user);
            userMeal = em.merge(userMeal);
        }
        return userMeal;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return em.createNamedQuery("Meal.delete").setParameter("id", id).setParameter("userId", userId).executeUpdate() != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        UserMeal userMeal = em.find(UserMeal.class, id);
        return userMeal.getUser().getId() != userId ? null : userMeal;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return em.createNamedQuery("Meal.getAll", UserMeal.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createNamedQuery("Meal.getAllBetween", UserMeal.class)
                .setParameter("userId", userId).setParameter("start", startDate).setParameter("end", endDate).getResultList();
    }
}