package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {
    public static final int MEAL_USER1_ID = 100002;
    public static final int MEAL_USER2_ID = 100003;
    public static final int MEAL_USER3_ID = 100004;
    public static final int MEAL_ADMIN1_ID = 100005;
    public static final int MEAL_ADMIN2_ID = 100006;
    public static final int MEAL_ADMIN3_ID = 100007;


    public static final UserMeal MEAL_USER1 = new UserMeal(MEAL_USER1_ID, LocalDateTime.parse("2016-03-23 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Завтрак", 440);
    public static final UserMeal MEAL_USER2  = new UserMeal(MEAL_USER2_ID, LocalDateTime.parse("2016-03-24 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Обед", 1000);
    public static final UserMeal MEAL_USER3 = new UserMeal(MEAL_USER3_ID, LocalDateTime.parse("2016-03-25 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Ужин", 505);
    public static final UserMeal MEAL_ADMIN1 = new UserMeal(MEAL_ADMIN1_ID, LocalDateTime.parse("2016-02-24 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Завтрак", 450);
    public static final UserMeal MEAL_ADMIN2  = new UserMeal(MEAL_ADMIN2_ID, LocalDateTime.parse("2016-02-24 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Обед", 1200);
    public static final UserMeal MEAL_ADMIN3 = new UserMeal(MEAL_ADMIN3_ID, LocalDateTime.parse("2016-02-24 19:54:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Ужин", 500);

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);

}
