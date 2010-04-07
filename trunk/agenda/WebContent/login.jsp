<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/template/cabecalho.jsp"/>

<form action="/agenda/login.view" method="post">
	<input type="hidden" name="acao" value="login"/>
	<table align="center">
		<tr>
			<td>Login:</td>
			<td>
				<input type="text" name="login" />
			</td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td>
				<input type="password" name="senha" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Acessar"/>
			</td>
		</tr>
	</table>
</form>

<jsp:include page="/template/rodape.jsp"/>
