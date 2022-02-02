<%@ page contentType="text/html;charset=UTF-8" %>

<div class="form" id="formRemove">
    <div class="close" onclick="switchFormVisibility('#formRemove')">&#215;</div>
    <h2>Remove car by ID</h2>
    <form action="/car/remove" method="post">
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Id</label>
                <input type="number" class="input-field" placeholder="1" name="id" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="btn-container">
                <input type="submit" value="Remove car" class="btn"/>
            </div>
        </div>
    </form>
</div>