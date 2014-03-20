<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpes-listado.title" /></title>
</head>
<body>
	<fmt:message key="format.datetime" var="pattern" scope="page" />

	<table class="table table-condensed">
		<c:forEach items="${tpess}" var="tpes" varStatus="status">
			<c:if test="${status.count % 4 == 1}">
				<tr>
			</c:if>

			<td><a
				href="estd-listado.action?estdCriterio.tpesId=${tpes.value}">${tpes.label}</a>
			</td>

			<c:if test="${status.count % 4 == 0 || status.last}">
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>
