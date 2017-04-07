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
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/login/logout">Logout</a></h1>
<a href="${pageContext.request.contextPath}/student/addStudent" style="margin-left: 1151px;margin-top: 18px;">ADD STUDENT</a><br>
<h1>Report</h1>
<%-- <a href="${pageContext.request.contextPath}/mail/chooseCommunication" style="margin-left: 1151px;margin-top: 18px;">Choose Communication</a></br>
<a href="${pageContext.request.contextPath}/mail/oneWayCommunication" style="margin-left: 1151px;margin-top: 18px;">One Way Communication</a></br>
<a href="${pageContext.request.contextPath}/mail/twoWayCommunication" style="margin-left: 1151px;margin-top: 18px;">Two Way Communication</a></br>
 --%>	<c:if test="${!empty student}">
		<table class="table table-condensed">
		<tr>
			<th>S.No</th>
			<th>Register Number</th>
			<th>Name</th>
		    <th>Image</th>
			<th>Action</th>
		</tr>
			
			<c:forEach items="${students }" var="s" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${s.registerNumber }</td>
			<td>${s.name }</td>
		    <td>
		    	<img width="100" height="100" alt="Embedded Image" src="data:image/png;base64,${s.profileImage }" />
		    </td>
					
			<td colspan="2"><a href="${pageContext.request.contextPath}/student/edit?id=${s.id }">Edit
			<%-- <img style="width: 32px; height: 32px;" title="Edit" src="${pageContext.request.contextPath}/images/editicon.png"> --%>
			</a> &nbsp;&nbsp;
			 <a  onclick="return confirm('Are u sure delete?')" href="${pageContext.request.contextPath}/student/delete?id=${s.id }">Delete
			 <%-- <img style="width: 32px; height: 32px;" title="Delete" src="${pageContext.request.contextPath}/images/deleteicon.png"> --%>
			 </a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>