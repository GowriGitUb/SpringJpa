<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jpa Project</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* To active the module */
		$('#custom-bootstrap-menu.navbar-default .navbar-nav > li')
				.removeClass('active');
		$('#menu-right #KnowledgeWise').attr('class', 'active');
	});
	
	/* Validate the form fields */
	function validate() {
		var title = $("#title").val();
		var description = $("#description").val();
		if (title == "") {
			alert("Title should not be empty");
			$("#title").focus();
			return false;
		}
		if (description == "") {
			alert("Description should not be empty");
			$("#description").focus();
			return false;
		}
	}
</script>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/login/logout">Logout</a></h1>
	<div class="content">
		<div class="content-wrap">
	<form:form action="${pageContext.request.contextPath}/student/addStudent" method="post" 
				cssClass="form-horizontal" modelAttribute="student" enctype="multipart/form-data">
				 <input type="hidden" name="id" id="id" value='<c:out value="${student.id }"></c:out>'/>
			
				<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-2">Register Number:</label>
						<div class="col-xs-10">
							<form:input class="form-control" id="registerNumber" placeholder="Enter the Register Number" path="registerNumber" />
						</div>
				</div>
				
				 <div class="form-group">
						<label for="inputPassword" class="control-label col-xs-2">Name:</label>
						<div class="col-xs-10">
							<form:input class="form-control" id="name" placeholder="Enter the Name" path="name" />
						</div>
				</div>
				
				  <div class="form-group">
					    <input type="hidden" name="fileUpload" id="fileUpload"/>
						<label for="inputPassword" class="control-label col-xs-2">Profile Image:</label>
						<div class="col-xs-10">
							<input type="file" name="fileUpload" id="fileUpload"  size="50" accept="image/gif, image/jpeg, image/png" class="form-control"  placeholder="Select Image"/> 
						</div>
				</div> 
				
				<%-- <label>
					<input type="hidden" name="fileUpload" id="fileUpload"/>
					<span>Profile Image&nbsp;&nbsp;</span>
					<input type="file" name="fileUpload" size="50" />${imageName }
				</label> --%>
				
				<div class="form-group">
						<div class="col-xs-offset-2 col-xs-10" style="margin: 10px; margin-left: 205px;">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</div>
				</div> 
				
		
	</form:form>
	</div>
	</div>
</body>
</html>