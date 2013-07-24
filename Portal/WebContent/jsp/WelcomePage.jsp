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
<f:view>

	
	<f:loadBundle basename="de.jopp.jsf.portal.resources.messages" var="msg"/>
	
	<h:panelGrid columns="2" style="margin: 0 auto; width: 98%">
		<h:column>
		<div align="left">
		<h:outputFormat value="#{msg.loggeduser}">
			<f:param value="#{user.username}"></f:param>
		</h:outputFormat>
		</div>
		</h:column>
		<h:column>
		<div align="right">
		<h:form>
			<h:commandButton action="#{user.logout}" value="#{msg.exit}">
			</h:commandButton>
		</h:form>
		</div>
		</h:column>
	</h:panelGrid>
	
	<h:panelGrid style="margin: 0 auto; margin-top: 100px;">
		<h:outputFormat value="#{msg.welcome}">
			<f:param value="#{user.username}"></f:param>
		</h:outputFormat>
	</h:panelGrid>
	
</f:view>
</body>
</html>