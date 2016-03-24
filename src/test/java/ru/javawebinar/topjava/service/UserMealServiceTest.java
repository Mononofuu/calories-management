package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class UserMealServiceTest {

    @Autowired
    protected UserMealService mealService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void get() throws Exception {
        UserMeal userMeal = mealService.get(MEAL_USER1_ID, USER_ID);
        MATCHER.assertEquals(userMeal, MEAL_USER1);
    }

    @Test(expected = NotFoundException.class)
    public void getWrongUser() throws Exception {
        mealService.get(MEAL_USER1_ID, ADMIN_ID);
    }

    @Test
    public void delete() throws Exception {
        mealService.delete(MEAL_USER1_ID, USER_ID);
        mealService.delete(MEAL_USER2_ID, USER_ID);
        mealService.delete(MEAL_USER3_ID, USER_ID);
        MATCHER.assertCollectionEquals(Collections.emptyList(), mealService.getAll(100000));
    }

    @Test(expected = NotFoundException.class)
    public void deleteWrongUser() throws Exception {
        mealService.delete(MEAL_USER1_ID, ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    public void updateWrongUser() throws Exception {
        //TODO
    }

    @Test
    public void getBetweenDates() throws Exception {
        Collection<UserMeal> mealCollection = mealService.getBetweenDates(LocalDate.parse("2016-03-24",
                DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2016-03-24",
                DateTimeFormatter.ofPattern("yyyy-MM-dd")), USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL_USER2), mealCollection);
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        Collection<UserMeal> mealCollection = mealService.getBetweenDateTimes(LocalDateTime.parse("2016-03-24 20:55:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.parse("2016-03-24 21:54:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), USER_ID);
        MATCHER.assertCollectionEquals(Collections.emptyList(), mealCollection);
    }

    @Test
    public void getAll() throws Exception {
        Collection<UserMeal> meals = mealService.getAll(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL_USER3, MEAL_USER2, MEAL_USER1), meals);
    }

    @Test
    public void update() throws Exception {
        UserMeal meal = new UserMeal(MEAL_USER1_ID, LocalDateTime.parse("2015-03-24 20:04:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Поздний обед", 700);
        mealService.update(meal, USER_ID);
        MATCHER.assertEquals(meal, mealService.get(MEAL_USER1_ID, USER_ID));

    }

    @Test
    public void save() throws Exception {
        UserMeal userMeal = new UserMeal(LocalDateTime.parse("2016-03-24 20:04:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Поздний ужин", 650);
        userMeal = mealService.save(userMeal, ADMIN_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(userMeal, MEAL_ADMIN1, MEAL_ADMIN2, MEAL_ADMIN3),
                mealService.getAll(ADMIN_ID));
    }
}