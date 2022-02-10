<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="top-container">
    <div class="user-info">
        <sec:authorize access="isAuthenticated()">
            <p>Hello, <b><sec:authentication property="name"/></b>!</p>
        </sec:authorize>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <p><sec:authentication property="details"/></p>
            <p><sec:authentication property="principal"/></p>
            <p><b>Cache of cars: </b>${carsCache}</p>
            <p><b>Cache of car: </b>${carCache}</p>
        </sec:authorize>
    </div>
    <div class="top-row">
        <a class="btn" onclick="history.back()">&larr; Go back</a>
        <input type="button" value="Add new" class="btn" onclick="switchFormVisibility('#formAdd')"/>
        <input type="button" value="Remove by Id" class="btn" onclick="switchFormVisibility('#formRemove')"/>
        <input type="button" value="Find by mark" class="btn" onclick="switchFormVisibility('#formFindCarByMark')"/>
        <input type="button" value="Find by mark&model&speed" class="btn"
               onclick="switchFormVisibility('#formFindByMarkModelSpeed')"/>
    </div>
</div>