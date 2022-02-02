<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cars service</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/App.css">
</head>
<body>

<jsp:include page="../modules/topMenu.jsp"/>

<div class="section">
    <div class="section_container">
        <h1>List of cars:</h1>
        <div class="list_container">
            <c:forEach items="${cars}" var="car">
                <div class="list_item">
                        <span>${car.id}</span><b>${car.mark} ${car.model}</b>
                    [V ${car.engine} - ${car.speed} km/h] ($${car.price})
                </div>
            </c:forEach>
        </div>
        <jsp:include page="../modules/addCarForm.jsp"/>
        <jsp:include page="../modules/removeCarById.jsp"/>
        <jsp:include page="../modules/findCarByMark.jsp"/>
        <jsp:include page="../modules/findByMarkModelSpeed.jsp"/>
    </div>
</div>
<div class="section">
    <div class="section-container">
        <div class="btn-container">
            <a href="/car/deleteAllAudi" class="btn">Delete all audi</a>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/app.js"></script>
</body>
</html>
