<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<jsp:include page="/template/cabecalho.jsp"/>

Bem vindo a AgendaWeb!<br><br>

  	<display:table name="contatos" export="true" requestURI="" sort="list" pagesize="3" id="contato" class="simple">
	    <display:column property="id" title="Id" group="1" sortable="true" headerClass="sortable" />
	    <display:column property="nome" title="Nome" group="2" sortable="true" headerClass="sortable" />
	    <display:column property="email" title="Email" group="2" sortable="true" headerClass="sortable" />

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