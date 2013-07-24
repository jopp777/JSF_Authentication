<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:loadBundle basename="de.jopp.jsf.portal.resources.messages" var="msg"/>
<center>
<f:view>
	<h:form>
		<h:panelGrid columns="1" style="margin: 0 auto; margin-top: 100px; text-align: center;" >
			<h:outputLabel value="#{msg.failed}"></h:outputLabel>
			<h:commandButton action="login" value="#{msg.goback}"></h:commandButton>
		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>
</html>