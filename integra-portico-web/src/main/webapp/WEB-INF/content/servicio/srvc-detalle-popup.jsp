<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.detalle">
        <fmt:param value="${enti.nombre} (${item.etiqueta})" />
    </fmt:message></title>
</head>
<body>
    <jsp:include page="content/srvc-detalle-content.jsp" flush="true">
        <jsp:param value="false" name="btnOn" />
    </jsp:include>
</body>
</html>
