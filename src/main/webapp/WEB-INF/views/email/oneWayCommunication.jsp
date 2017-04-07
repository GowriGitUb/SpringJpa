<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h2>One Way Communication</h2>
	<form>
		<table align="center">
			<tr>
				<td>To Address&nbsp;<span style="color: red">*</span> :</td>
				<td><textarea name="toAddress" id="toAddress" rows="5"
						cols="20"></textarea></td>
			</tr>
			<tr>
				<td>Subject&nbsp;<span style="color: red">*</span> :</td>
				<td><input type="text" name="subject" id="subject" /></td>
			</tr>
			<tr>
				<td>Message&nbsp;<span style="color: red">*</span> :</td>
				<td><textarea name="message" id="message" rows="5" cols="20"></textarea></td>
			</tr>
			<tr>
				<td>Immediate&nbsp;<span style="color: red">*</span> :</td>
				<td><input type="checkbox" id="immediate" name="immediate" /></td>
			</tr>
			<tr>
				<td>Attachment :</td>
				<td><input type="file" id="attachment" name="attachment" /></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit" /> <input
					type="reset" value="Reset" /> <input type="button" value="Preview" /></td>
			</tr>
		</table>
	</form>
</body>
</html>