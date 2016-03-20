<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meal list</title>
    <link href="resources/bootstrap.min.css" rel="stylesheet" type="text/css">
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal list</h3>
    <a href="meals?action=create">Add Meal</a>
    <hr>
    <h3>Фильтры</h3>
    <form action="meals?action=filter" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2">From date</label>
            <div class="col-sm-2">
                <input type="date" name="dateFrom"/>
            </div>
            <label class="control-label col-sm-2">To date</label>
            <div class="col-sm-2">
                <input type="date" name="dateTo"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">From time</label>
            <div class="col-sm-2">
                <input type="time" name="timeFrom"/>
            </div>
            <label class="control-label col-sm-2">To time</label>
            <div class="col-sm-2">
                <input type="time" name="timeTo"/>
            </div>
        </div>
        <input type="submit" class="btn">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.UserMealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        ${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>