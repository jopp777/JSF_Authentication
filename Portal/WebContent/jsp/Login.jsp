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
	<!-- <center> -->
		<f:view>
			<f:loadBundle basename="de.jopp.jsf.portal.resources.messages" var="msg"/>
			<h:outputFormat rendered="#{user.loggedIn}" value="#{msg.loggeduser}">
				<f:param value="#{user.username}"></f:param>
			</h:outputFormat>
			<h:form>
			<h:panelGrid columns="2" style="margin: 0 auto; margin-top: 100px;">
				<h:outputLabel value="#{msg.user}"></h:outputLabel>
				<h:inputText value="#{user.username}">
					<f:validator validatorId="de.jopp.jsf.portal.validators.LoginValidator"/>
				</h:inputText>
				<h:outputLabel value="#{msg.password}"></h:outputLabel>
				<h:inputSecret value="#{user.password}"></h:inputSecret>
			</h:panelGrid>
			<h:panelGrid columns="2" style="margin: 0 auto;">
				<h:commandButton action="#{user.login}" value="#{msg.login}">
				</h:commandButton>
				<h:commandButton immediate="true" action="#{language.changeLang}" value="#{msg.language}">
				</h:commandButton>
			</h:panelGrid>
			<h:messages layout="table"></h:messages>
			</h:form>
			
		</f:view>
	<!-- </center> -->
</body>
</html>