<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="mabl.totales.title" /> (${ssrv.srvc.etiqueta} - ${ssrv.numero})</title>
</head>
<body>
    <c:set var="resumen" value="${resumen}" scope="request" />

    <jsp:include page="content/resumen-content.jsp" flush="true" />
</body>
</html>
