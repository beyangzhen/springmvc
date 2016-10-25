<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<a href="demo/helloWorld">hello world</a>
		
		<form action="demo/testREST" method="get">
			<input type="submit" value="submit_GET"/>
		</form>
		<br/>
		<form action="demo/testREST" method="post">
			<input type="submit" value="submit_POST"/>
		</form>
		<br/>
		<form action="demo/testREST" method="post">
			<input type="hidden" name="_method" value="PUT">
			<input type="submit" value="submit_put"/>
		</form>
		<br/>
		<form action="demo/testREST" method="post">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="submit_delete"/>
		</form>
		<br/>
		
		<a href="demo/testAnt/abc/123">test Ant</a><br/><br/>
		
		<form action="demo/testMethod" method="post">
			<input type="submit" value="submit"/>
		</form><br/>
		
		<a href="demo/testParam?userName=bruce&age=8">test param</a><br/><br/>
	
		<a href="demo/testPathVariable/120">test PathVariable</a><br/><br/>
		
		<a href="testParameters?userName=wxhl&age=12">test parameters</a><br/><br/>
		
	    <a href="testHeader">test Header</a><br/><br/>
	    
	    <a href="testCookie">test Cookie</a><br/><br/>
	    
	    <form action="testPOJO" method="post">
	   	    <label>名字</label><input type="text" name="userName" value=""/><br/>
	   	    <label>密码</label><input type="text" name="password" value=""/><br/>
	   	    <label>邮箱</label><input type="text" name="email" value=""/><br/>
	   	    <label>年龄</label><input type="text" name="age" value=""/><br/>
	   	    <label>省份</label><input type="text" name="address.provice" value=""/><br/>
	   	    <label>城市</label><input type="text" name="address.city" value=""/><br/>
	   	    <input type="submit" value="提交"/>
	    </form><br/>
		
	</body>
</html>