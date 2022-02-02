<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Search results</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/App.css">
</head>
<body>
<jsp:include page="../modules/topMenu.jsp"/>
<div class="section">
    <div class="section_container">
        <h1>Search results</h1>
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
