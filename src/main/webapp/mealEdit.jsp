<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.UserMeal"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal Edit</title>
</head>
<body>
<form action="meals" method="POST">

    <input type="text" name="id" value="${meal.id}" hidden><br>
    Description: <input type="text" name="description" value="${meal.description}"><br>
    Calories: <input type="text" name="calories" value="${meal.calories}"><br>
    Date: <input type="datetime-local" name="date" value="${meal.dateTime}"><br>
    <input type="submit">
    <button onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
