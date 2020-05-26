<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="user"  >
   id:<sf:input type="text" path="id" name="id"/>
         用户名:<sf:input type="text" path="username" name="username"/>
         密码:<sf:input type="text" path="password" name="password"/>
   <input type="submit" value="用户添加" />
</sf:form>
</body>
</html>