<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="css/App.css">
    <script type="text/javascript" src="js/app.js"></script>
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
        <div class="form" id="formAdd">
            <div class="close">&#215;</div>
            <h2>Add new car</h2>
            <form action="">
                <div class="form-row">
                    <jsp:include page="../modules/input.jsp">
                        <jsp:param name="label" value="Subject"/>
                        <jsp:param name="placeholder" value="Your subject"/>
                    </jsp:include>
                    <jsp:include page="../modules/input.jsp">
                        <jsp:param name="label" value="Some label"/>
                        <jsp:param name="placeholder" value="Your some value"/>
                    </jsp:include>
                </div>
                <div class="form-row">
                    <jsp:include page="../modules/input.jsp">
                        <jsp:param name="label" value="E-mail"/>
                        <jsp:param name="placeholder" value="Type your email"/>
                    </jsp:include>
                </div>
                <div class="form-row">
                    <jsp:include page="../modules/button.jsp">
                        <jsp:param name="text" value="Search by..."/>
                    </jsp:include>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
