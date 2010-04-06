<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/template/cabecalho.jsp"/>

<form action="/agenda/altera-contato.view">
<input type="hidden" name="id" value="${contato.id}"/>
	<table>
		<tr>
			<td>Nome:</td>
			<td>
				<input type="text" name="nome" value="${contato.nome}"/>
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>
				<input type="text" name="email" value="${contato.email}"/>
			</td>
		</tr>
		<tr>
			<td>Endereço</td>
			<td>
				<input type="text" name="endereco" value="${contato.endereco}"/>
			</td>
		</tr>
		<tr>
			<td>Data Nascimento</td>
			<td>
				<input type="text" name="dataNascimento" value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />" /><br />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar"/></td>
		</tr>	
	</table>
</form>

<jsp:include page="/template/rodape.jsp"/>