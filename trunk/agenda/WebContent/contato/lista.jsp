<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<jsp:include page="/template/cabecalho.jsp"/>

	<display:table name="contatos" export="true" sort="list" pagesize="10" id="contato" class="simple">
	    <display:column property="nome" title="Nome" sortable="true" headerClass="sortable" />
	    <display:column property="email" title="Email" sortable="true" headerClass="sortable" />
	    <display:column property="endereco" title="Endereço" sortable="true" headerClass="sortable" />
	    <display:column media="html" title="Data Nascimento">
		    <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
	    </display:column>
	    <display:column media="html" title="Edit">
			<a href="<c:url value="/contato/edita.view?id=${contato.id}"/>">
				<img src="<c:url value="/template/img/add.png" />" alt="Editar" width="20px" height="20px"/>
			</a>
	    </display:column>
	    <display:column media="html" title="Del">
			<a href="<c:url value="/contato/remove.view?id=${contato.id}"/>">
				<img src="<c:url value="/template/img/delete.png" />" alt="Remover" width="20px" height="20px"/>
			</a>
	    </display:column>
	    <display:setProperty name="export.csv" value="true" />
	    <display:setProperty name="export.excel" value="true" />
	    <display:setProperty name="export.xml" value="true" />
	    <display:setProperty name="export.pdf" value="true" />
	    <display:setProperty name="export.rtf" value="true" />
	    <display:setProperty name="export.csv.filename" value="produtos.csv"  />
	    <display:setProperty name="export.excel.filename" value="produtos.xls"  />
	    <display:setProperty name="export.xml.filename" value="produtos.xml"  />
	    <display:setProperty name="export.pdf.filename" value="produtos.pdf"  />
		<display:setProperty name="export.rtf.filename" value="produtos.rtf"  />
	</display:table>
  
<jsp:include page="/template/rodape.jsp"/>  