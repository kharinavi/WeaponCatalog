<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Weapon List</title>
</head>
<body>
<div th:each = "weapon : ${weapons}">
  <a th:href = "@{/weapons/{id}(id=${weapon.getId()})}" th:text="${weapon.getName()}">users</a>
</div>

<br/>
<hr/>
<a href="/weapons/new">Create new person</a>

</body>
</html>