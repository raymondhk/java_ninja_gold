<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./../resources/css/style.css">
<title>Ninja Gold</title>
</head>
<body>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 text-center">
				<h1>Ninja Gold!</h1>
				<h5>Click on each of the buttons to see how much your ninja can earn!</h5>
				<h5>But be careful at the casino... you could lose it all!</h5>
			</div>
			<div class="col-md-4"></div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12"><h4>Your Gold: <c:out value="${gold}"/>     <a href="/reset" class="btn btn-default">Reset</a></h4></div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-3">
				<div class="box text-center" id="farm">
					<h3>Farm</h3>
					<h5>(earn 10-15 gold)</h5>
					<br>
					<br>
					<a href="/farm" class="btn btn-success">Find Gold!</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="box text-center" id="cave">
					<h3>Cave</h3>
					<h5>(earn 5-10 gold)</h5>
					<br>
					<br>
					<a href="/cave" class="btn btn-success">Find Gold!</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="box text-center" id="house">
					<h3>House</h3>
					<h5>(earn 2-5 gold)</h5>
					<br>
					<br>
					<a href="/house" class="btn btn-success">Find Gold!</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="box text-center">
					<h3>Casino</h3>
					<h5>(earn/lose 0-50 gold)</h5>
					<br>
					<br>
					<a href="/casino" class="btn btn-warning">Find Gold!</a>
				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h3>Activites:</h3>
				<div class="message_box">
				<c:forEach items="${messages}" var="message">
					<p><c:out value="${message}"/></p>
				</c:forEach>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br>
	</div>
</body>
</html>