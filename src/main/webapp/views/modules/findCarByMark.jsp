<%@ page contentType="text/html;charset=UTF-8" %>

<div class="form" id="formFindCarByMark">
    <div class="close" onclick="switchFormVisibility('#formFindCarByMark')">&#215;</div>
    <h2>Remove car by ID</h2>
    <form action="/car/findByMark" method="get">
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Mark</label>
                <input type="text" class="input-field" placeholder="Audi" name="mark" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="btn-container">
                <input type="submit" value="Find car" class="btn"/>
            </div>
        </div>
    </form>
</div>