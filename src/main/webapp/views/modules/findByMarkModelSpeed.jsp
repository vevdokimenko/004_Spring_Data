<%@ page contentType="text/html;charset=UTF-8" %>

<div class="form" id="formFindByMarkModelSpeed">
    <div class="close" onclick="switchFormVisibility('#formFindByMarkModelSpeed')">&#215;</div>
    <h2>Find by mark, model and speed</h2>
    <form action="/car/findByMarkAndModelAndSpeed" method="get">
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Mark</label>
                <input type="text" class="input-field" placeholder="Audi" name="mark" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Model</label>
                <input type="text" class="input-field" placeholder="A6" name="model" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Speed</label>
                <input type="number" class="input-field" placeholder="280" name="speed" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="btn-container">
                <input type="submit" value="Find car" class="btn"/>
            </div>
        </div>
    </form>
</div>