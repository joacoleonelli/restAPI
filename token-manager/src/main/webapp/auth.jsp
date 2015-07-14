<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    // TODO test implementation
	String url = "https://localhost:8243/authorize?response_type=code&client_id=KtRdKshILle7jPVLlsCzVwKaEQEa&redirect_uri=http://localhost:8080/token-manager/incoming_auth.jsp";
    url += "&scope=get_career";
    response.sendRedirect(url);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
	</body>
</html>