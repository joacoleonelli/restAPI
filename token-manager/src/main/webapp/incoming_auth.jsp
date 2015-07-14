<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.Base64"%>
<%@page import="org.apache.http.client.fluent.Content"%>
<%@page import="org.apache.http.client.fluent.Form"%>
<%@page import="org.apache.http.client.fluent.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    System.setProperty("javax.net.ssl.trustStore", "/home/spoblete/trust.jks");
    System.setProperty("javax.net.ssl.trustStorePassword", "carbon");

    // Get the token
    String uri = "https://localhost:8243/token";
    final byte[] authBytes = "KtRdKshILle7jPVLlsCzVwKaEQEa:CeKOWzXcPEhXitVvCMzkfL7ij9sa".getBytes(StandardCharsets.UTF_8);
    Content content = Request
            .Post(uri)
            .addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(authBytes))
            .bodyForm(
                    Form.form().add("grant_type", "authorization_code").add("code", request.getParameter("code"))
                            .add("scope", "get_career")
                            //.add("client_id", "TIyXX_UhMQ2bnme4HA0tVec0lDIa").add("client_secret", "sGXJ8gqeD8I86bmL2KPLaaPFPMwa")
                            .add("redirect_uri", "http://localhost:8080/token-manager/incoming_auth.jsp").build()).execute()
            .returnContent();
    
    // TODO Get login service
    
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<%=content.asString()%>
	</body>
</html>