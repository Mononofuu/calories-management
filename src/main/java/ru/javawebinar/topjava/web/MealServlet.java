package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.repository.MapUserMealDAOImpl;
import ru.javawebinar.topjava.repository.UserMealDAO;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);
    private static final UserMealDAO userMealDAO = new MapUserMealDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        LOG.debug("Action: " + action);
        String id = request.getParameter("id");
        switch (action) {
            case "edit": {
                request.setAttribute("meal", userMealDAO.read(Integer.parseInt(id)));
                request.getRequestDispatcher("/mealEdit.jsp").forward(request, response);
                break;
            }
            case "delete": {
                int idToDelete = Integer.parseInt(request.getParameter("id"));
                userMealDAO.delete(idToDelete);
                LOG.debug("Meal deleted. Id: " + idToDelete);
                response.sendRedirect("meals");
                break;
            }
            case "create": {
                UserMeal meal = new UserMeal(LocalDateTime.now(), "", 0);
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/mealEdit.jsp").forward(request, response);
                break;
            }
            default: {
                LOG.debug("redirect to userList");
                List<UserMeal> mealList = userMealDAO.readAll();
                List<UserMealWithExceed> userMealsWithExceeded = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
                request.setAttribute("meals", userMealsWithExceeded);
                LOG.debug("Founded meals: " + userMealsWithExceeded.size());
                LOG.debug("forward to userList");
                request.getRequestDispatcher("/mealList.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LOG.debug("Create/Update Meal");
        int calories = Integer.parseInt(request.getParameter("calories"));
        String description = request.getParameter("description");
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        UserMeal userMeal = (id.equals("0")) ? new UserMeal(LocalDateTime.now(), description, calories) :
                userMealDAO.read(Integer.parseInt(id));
        userMeal.setCalories(calories);
        userMeal.setDescription(description);
        userMeal.setDateTime(LocalDateTime.parse(date));
        userMealDAO.update(userMeal);
        response.sendRedirect("meals");
    }
}
