<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="css/App.css">
</head>
<body>
<a href="/">&larr; Go back</a>
<div class="app">
    <div class="app_start_container">
        <h1>List of cars:</h1>
        <div class="list_container">
            <c:forEach items="${cars}" var="car">
                <div class="list_item">
                        <span>${car.id}</span><b>${car.mark} ${car.model}</b>
                    [V ${car.engine} - ${car.speed} km/h] ($${car.price})
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
