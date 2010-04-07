<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/template/cabecalho.jsp"/>

<table border="1">
	<tr>
		<td align="center" colspan="6">Lista de Contatos</td>
	</tr>
	<tr>
		<td>Nome</td>
		<td>Email</td>
		<td>Endereço</td>
		<td>Data Nascimento</td>
		<td>Editar</td>
		<td>Excluir</td>
	</tr>
	<c:if test="${not empty contatos}">
		<c:forEach items="${contatos}" var="contato">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td><a href="/agenda/contato/edita.view?id=${contato.id}">Editar</a></td>
				<td><a href="/agenda/contato/remove.view?id=${contato.id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty contatos}">
		<tr>
			<td colspan="6" align="center">Não constam registros</td>
		</tr>
	</c:if>
</table>

<jsp:include page="/template/rodape.jsp"/>




