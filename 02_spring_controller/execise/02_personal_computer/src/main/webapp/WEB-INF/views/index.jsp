<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<fieldset>
    <legend><h2>Calculator</h2></legend>
    <form action="/calculator" method="get">
        <div class="form-group">
            <label>first Number:</label>
            <input style="width: 200px" class="form-control" type="text" name="firstNumber" value="${firstNumber}">
            <label>Last Number:</label>
            <input style="width: 200px" class="form-control" type="text" name="lastNumber" value="${lastNumber}">

            <button class="btn btn-primary" type="submit" name="operator" value="Addition">Addition(+)</button>
            <button class="btn btn-primary" type="submit" name="operator" value="Subtraction">Subtraction(-)</button>
            <button class="btn btn-primary" type="submit" name="operator" value="Multiplication">Multiplication(X)</button>
            <button class="btn btn-primary" type="submit" name="operator" value="Division">Division(/)</button>

            <h2>Result: ${result}</h2>
        </div>
    </form>
</fieldset>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
