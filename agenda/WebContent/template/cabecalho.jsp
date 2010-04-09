<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Agenda Web</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/template/css/displaytag.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/template/css/alternative.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/template/css/main.css" />" />
</head>

<body>

   <!-- Begin Wrapper -->
   <div id="wrapper">
   
         <!-- Begin Header -->
         <div id="header">
         	
	       Agenda de Contatos - Servlets, Jsp, HTML, Css.

		 </div>
		 <!-- End Header -->
		 
		 <!-- Begin Navigation -->
         <div id="navigation">
		 
		       Olá
		       <c:if test="${not empty usuarioWeb}">
		       		${usuarioWeb.nome}!
		       		<a href="/agenda/logout.view">Sair</a>
		       </c:if>
			   <c:if test="${empty usuarioWeb}">
		       		Visitante! 
		       		<a href="/agenda/login.jsp">Acessar</a>
		       </c:if>		       		 
			   
		 </div>
		 <!-- End Navigation -->
		 
         <!-- Begin Faux Columns -->
		 <div id="faux">
		 
		       <!-- Begin Left Column -->
		       <div id="leftcolumn">
		 			<c:if test="${not empty usuarioWeb}">
			 			<ul>
			 				<li><a href="/agenda/contato/lista.view">Lista contato</a></li>
			 				<li><a href="/agenda/contato/form.view">Adiciona contato</a></li>
			 			</ul>
		 			</c:if>
		       </div>
		       <!-- End Left Column -->
		 
		       <!-- Begin Right Column -->
		       <div id="rightcolumn">
		       	<div id="errors">
			       	<c:forEach items="${errors}" var="error">
			       		${error.mensagem}
			       	</c:forEach>
		       	</div>