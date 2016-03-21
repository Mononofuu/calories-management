package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);

    private static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
    private UserMealRestController mealController = context.getBean(UserMealRestController.class);

    @Override
    public void destroy() {
        super.destroy();
        context.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("filter".equals(action)) {
            LocalDate dateFrom = LocalDate.MIN;
            LocalDate dateTo = LocalDate.MAX;
            LocalTime timeFrom = LocalTime.MIN;
            LocalTime timeTo = LocalTime.MAX;
            Optional<String> dateFromValue = Optional.of(request.getParameter("dateFrom"));
            Optional<String> dateToValue = Optional.of(request.getParameter("dateTo"));
            Optional<String> timeFromValue = Optional.of(request.getParameter("timeFrom"));
            Optional<String> timeToValue = Optional.of(request.getParameter("timeTo"));
            if (dateFromValue.isPresent() && !dateFromValue.get().isEmpty()) {
                dateFrom = LocalDate.parse(dateFromValue.get());
            }
            if (dateToValue.isPresent() && !dateToValue.get().isEmpty()) {
                dateTo = LocalDate.parse(dateToValue.get());
            }
            if (timeFromValue.isPresent() && !timeFromValue.get().isEmpty()) {
                timeFrom = LocalTime.parse(timeFromValue.get());
            }
            if (timeToValue.isPresent() && !timeToValue.get().isEmpty()) {
                timeTo = LocalTime.parse(timeToValue.get());
            }
            LOG.info("getAllFiltered");
            request.setAttribute("mealList", mealController.getAll(dateFrom, timeFrom, dateTo, timeTo));
            request.getRequestDispatcher("/mealList.jsp").forward(request, response);

        } else {
            String id = request.getParameter("id");
            UserMeal userMeal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id),
                    LocalDateTime.parse(request.getParameter("dateTime")),
                    request.getParameter("description"),
                    Integer.valueOf(request.getParameter("calories")), LoggedUser.getId());
            LOG.info(userMeal.isNew() ? "Create {}" : "Update {}", userMeal);
            mealController.save(userMeal);
        }
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            LOG.info("getAll");
            String loggedUserId = request.getParameter("user");
            if (loggedUserId != null) {
                LoggedUser.setId(Integer.parseInt(loggedUserId));
            }
            request.setAttribute("mealList", mealController.getAll());
            request.getRequestDispatcher("/mealList.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = getId(request);
            LOG.info("Delete {}", id);
            mealController.delete(id);
            response.sendRedirect("meals");
        } else {
            final UserMeal meal = "create".equals(action) ?
                    new UserMeal(LocalDateTime.now(), "", 1000, LoggedUser.getId()) :
                    mealController.get(getId(request));
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request, response);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
