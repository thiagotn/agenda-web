<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/template/cabecalho.jsp"/>

<form action="/agenda/adiciona-contato.view">
	<table>
		<tr>
			<td>Nome:</td>
			<td>
				<input type="text" name="nome"/>
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>
				<input type="text" name="email"/>
			</td>
		</tr>
		<tr>
			<td>Endereço</td>
			<td>
				<input type="text" name="endereco"/>
			</td>
		</tr>
		<tr>
			<td>Data Nascimento</td>
			<td>
				<input type="text" name="dataNascimento"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar"/></td>
		</tr>	
	</table>
</form>

<jsp:include page="/template/rodape.jsp"/>