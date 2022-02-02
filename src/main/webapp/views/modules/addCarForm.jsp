<%@ page contentType="text/html;charset=UTF-8" %>
<div class="dark"></div>
<div class="form" id="formAdd">
    <div class="close" onclick="switchFormVisibility('#formAdd')">&#215;</div>
    <h2>Add new car</h2>
    <form action="/car/add" method="post">
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Mark</label>
                <input type="text" class="input-field" placeholder="Audi" name="mark" required/>
            </div>
            <div class="input-container">
                <label for class="input-label">Model</label>
                <input type="text" class="input-field" placeholder="A6" name="model" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="input-container">
                <label for class="input-label">Engine, cm<sup>3</sup></label>
                <input type="number" step="0.1" class="input-field" placeholder="3.0" name="engine" required/>
            </div>
            <div class="input-container">
                <label for class="input-label">Price, USD</label>
                <input type="number" class="input-field" placeholder="20000" name="price" required/>
            </div>
            <div class="input-container">
                <label for class="input-label">Speed, km/h</label>
                <input type="number" class="input-field" placeholder="280" name="speed" required/>
            </div>
        </div>
        <div class="form-row">
            <div class="btn-container">
                <input type="submit" value="Add new car" class="btn"/>
            </div>
        </div>
    </form>
</div>