<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/13/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form:form action="/save" method="post" modelAttribute="emailBoxList">
  <table>
    <tr>
      <td><form:hidden path="id"/></td>
    </tr>

    <tr>
      <td>Languages</td>
      <td><form:select path="languages" items="${languagesList}"/>
    </tr>

    <tr>
      <td>Page size</td>
      <td>
        show <form:select path="pageSize" items="${pageSizeList}" /> emails per page
      </td>
    </tr>

    <tr>
      <td>Spams filter</td>
      <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
    </tr>
    <tr>
      <td>Signature</td>
      <td><form:textarea path="signature"/></td>
    </tr>
    <tr>
      <td></td>
      <td><form:button>Update</form:button></td>
    </tr>
  </table>
</form:form>

  </body>
</html>
