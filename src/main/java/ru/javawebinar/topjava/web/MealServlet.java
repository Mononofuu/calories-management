package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to userList");
        List<UserMeal> mealList = UserMealsUtil.getMealList();
        List<UserMealWithExceed> userMealsWithExceeded = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        request.setAttribute("meals", userMealsWithExceeded);
        LOG.debug("Founded meals: " + userMealsWithExceeded.size());
        LOG.debug("forward to userList");
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
    }
}
