<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsr-listado.title" /></title>
</head>
<body>
    <c:forEach items="${tpsrs}" var="enti">
        <div class="panel panel-default col-md-4">
            <div class="panel-heading">
                <a href="srvc-listado.action?itemCriterio.entiId=${enti.value}">${enti.label}</a>
            </div>

            <c:if test="${not empty tpssMap[enti.value]}">
                <ul class="list-group">
                    <c:forEach items="${tpssMap[enti.value]}" var="entiHija">
                        <li class="list-group-item"><a
                            href="ssrv-listado.action?itemCriterio.entiId=${entiHija.value}">${entiHija.label}</a></li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </c:forEach>
</body>
</html>
