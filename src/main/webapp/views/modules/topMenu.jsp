<%@ page contentType="text/html;charset=UTF-8" %>

<div class="top-container">
    <div class="top-row">
        <a class="btn" onclick="history.back()">&larr; Go back</a>
        <input type="button" value="Add new" class="btn" onclick="switchFormVisibility('#formAdd')"/>
        <input type="button" value="Remove by Id" class="btn" onclick="switchFormVisibility('#formRemove')"/>
        <input type="button" value="Find by mark" class="btn" onclick="switchFormVisibility('#formFindCarByMark')"/>
        <input type="button" value="Find by mark&model&speed" class="btn" onclick="switchFormVisibility('#formFindByMarkModelSpeed')"/>
    </div>
</div>