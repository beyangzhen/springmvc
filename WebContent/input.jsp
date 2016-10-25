<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户信息页面</title>
</head>
<body>
	<form action="testUserCoverter" method="post">
		 <!--  userName/age/birthDay/salay/email     -->
		  用户信息：<input type="text" name="user"/>
		 <input type="submit" value="提交" />
	</form>
	<br/>
	<!-- 使用表单标签的好处：
		1. 快速的构建一个页面
		2. 方便回显示
	 -->	
	 
	<form:form action="user" method="post" modelAttribute="user">
		 <!-- 
		 <form:errors path="*"></form:errors>
		  -->
		 <!-- 
		 <input type="text" name="userName" value="${userName }"/>
		 -->
		 <c:if test="${userId==null}">
			 用户名：<form:input path="userName"/><br/>
		 </c:if>
		 <c:if test="${userId!=null}">
		 	 <!-- 把post请求转为put -->
			 <input type="hidden" name="_method" value="PUT"/>
			 <form:hidden path="userId"/>
		 </c:if>
		 年龄：<form:input path="userAge"/><br/>
		 生日：<form:input path="userBirth"/><br/>
		 月薪：<form:input path="salay"/><br/>
		 邮箱：<form:input path="email"/><br/>
		 班级：<form:select path="classes.classId"
		 				  items="${classesList}"
		 				  itemLabel="className"
		 				  itemValue="classId"
		 				  >
		 	 </form:select><br/>
		 <input type="submit" value="提交" />
	</form:form>
</body>
</html>