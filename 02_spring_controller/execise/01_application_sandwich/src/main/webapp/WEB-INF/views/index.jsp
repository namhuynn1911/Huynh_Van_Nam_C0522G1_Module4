<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments.</h1>
  <form method="get" action="save">
    <table>
      <tr>
        <td><input type="checkbox" value="Lettuce" name="condiments">Lettuce</td>
        <td><input type="checkbox" value="Tomato" name="condiments">Tomato</td>
        <td><input type="checkbox" value="Mustard" name="condiments">Mustard</td>
        <td><input type="checkbox" value="Sprouts" name="condiments">Sprouts</td>
        <td><input type="submit" value="save"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
